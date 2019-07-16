package com.ruoyi.project.llc.notes.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.file.InvalidExtensionException;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.llc.notes.domain.Notes;
import com.ruoyi.project.llc.notes.service.NotesService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @Author haien
 * @Description 笔记管理
 * @Date 2019/7/8
 **/

@Api("笔记管理")
@RestController
@RequestMapping("/admin/notes")
public class NotesController extends BaseController {

    private static final Logger logger=LoggerFactory.getLogger(NotesController.class);
    private static String Save_Url = FileUploadUtils.getDefaultBaseDir()+"notes/";
    private String prefix = "notes";
    //笔记文件类型
    private String[] notesExtension={"doc","docx"};

    @Resource
    private NotesService notesService;

    /**
     * @Author haien
     * @Description 自动创建目录
     * @Date 2019/7/9
     **/
    static{
        File saveDir=new File(Save_Url);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
    }

    /**
     * @Author haien
     * @Description 返回主页，页面加载时会通过ajax获取数据
     * @Date 2019/7/9
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping()
    public ModelAndView files() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName(prefix + "/notes");
        return modelAndView;
    }

    /**
     * @Author haien
     * @Description 查询笔记列表
     * @Date 2019/7/8
     * @Param [files]
     * @return com.ruoyi.framework.web.page.TableDataInfo
     **/
    @PostMapping("/list")
    public TableDataInfo list() {
        //分页
        startPage();
        List<Notes> list = notesService.seleteAllNotes();
        //返回分页对象
        return getDataTable(list);
    }

    /**
     * @Author haien
     * @Description 新增笔记上传
     * @Date 2019/7/9
     * @Param [mmap]
     * @return java.lang.String
     **/
    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView=new ModelAndView();
        Notes notes = new Notes();
        modelAndView.addObject("notes", notes);
        modelAndView.setViewName(prefix + "/add");
        return modelAndView;
    }

    /**
     * @Author haien
     * @Description 新增保存笔记上传
     * @Date 2019/7/9
     * @Param [file, files]
     * @return com.ruoyi.framework.web.domain.AjaxResult
     **/
    @Log(title = "笔记上传", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult save(MultipartFile file, Notes notes) {
        int rtn = 0;

        //笔记标题是否唯一
        if(checkNotesTitleUnqiue(notes).equals(UserConstants.DEPT_NAME_NOT_UNIQUE)){
            logger.error("笔记标题不唯一！");
            return error("标题已存在！");
        }

        try {
            notes = dealFile(file, notes);
            if (file != null) {
                if (notes.getUpdateFlag() == 1 && notes.getId() > 0) {//修改
                    if(ShiroUtils.getLoginName().equals(notes.getAuthor())) {
                        rtn = notesService.updateNotes(notes);
                    } else { //非本人
                        logger.error("超权限操作！");
                        return error("抱歉，您没有该权限！");
                    }
                 } else {//新增
                    rtn = notesService.insertNotes(notes);
                }

                //上传到服务器
                File desc = FileUploadUtils.getAbsoluteFile(Save_Url, notes.getUrl());
                file.transferTo(desc);
            }
        } catch (InvalidExtensionException e1) {
            logger.error("笔记文件类型错误！", e1);
            return error("请检查文件是否为Word文档！");
        } catch (Exception e2) {
            logger.error("保存失败，请检查后重试！", e2);
            return error(e2.getMessage());
        }

        return toAjax(rtn);
    }

    @Log(title = "删除笔记", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int rtn=0;

        if(!StringUtils.isEmpty(ids)) {
            //是否本人
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                Notes notes = notesService.selectById(Integer.valueOf(id));
                if (!ShiroUtils.getLoginName().equals(notes.getAuthor())) {
                    logger.error("超权限操作！");
                    return error("抱歉，您没有该权限！");
                }
            }

            rtn=notesService.deleteNotesByIds(ids);
        }

        return toAjax(rtn);
    }

    /**
     * @Author haien
     * @Description 查询本人笔记
     * @Date 2019/7/10
     * @Param [ids]
     * @return com.ruoyi.framework.web.domain.AjaxResult
     **/
    @PostMapping("/myList")
    public TableDataInfo manage(String ids){
        //分页
        startPage();
        //查询本人上传的笔记
        List<Notes> list = notesService.selectByAuthor(
                ShiroUtils.getSysUser().getLoginName());
        //返回分页对象
        return getDataTable(list);
    }

    public String checkNotesTitleUnqiue(Notes notes) {
        return notesService.checkNotesTitleUnqiue(notes);
    }

    /**
     * @Author haien
     * @Description 生成下载路径
     * @Date 2019/7/9
     * @Param [file, notes]
     * @return com.ruoyi.project.llc.notes.domain.Notes
     **/
    private Notes dealFile(MultipartFile file, Notes notes) throws Exception {
        if (file == null) return notes;

        //获取文件后缀
        String filename=file.getOriginalFilename();
        String suffix = FileUploadUtils.dealName(filename);

        if (StringUtils.isEmpty(suffix)) throw new Exception();

        //若笔记文件非Word文档
        if(!suffix.equals("doc") && !suffix.equals("docx")){
            throw new InvalidExtensionException(notesExtension,suffix,filename);
        }

        String name = Save_Url + notes.getTitle() + "." + suffix;
        notes.setUrl(name);

        return notes;
    }
}
