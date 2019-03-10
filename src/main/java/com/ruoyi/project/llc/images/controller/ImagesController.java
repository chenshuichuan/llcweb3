package com.ruoyi.project.llc.images.controller;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.project.llc.images.service.ImagesRepository;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.llc.images.domain.Images;
import com.ruoyi.project.llc.images.service.IImagesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片上传 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/images")
public class ImagesController extends BaseController
{
	private static final Logger log = LoggerFactory.getLogger(ImagesController.class);
    private String prefix = "llc/images";
    /**
     * 这个图片保存在
     */
	private static String Save_Url = FileUploadUtils.getDefaultBaseDir()+"images/";
	
	@Autowired
	private IImagesService imagesService;
    @Autowired
    private ImagesRepository imagesRepository;
	@RequiresPermissions("llc:images:view")
	@GetMapping()
	public String images()
	{
	    return prefix + "/images";
	}
	
	/**
	 * 查询图片上传列表
	 */
	@RequiresPermissions("llc:images:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Images images)
	{
		startPage();
        List<Images> list = imagesService.selectImagesList(images);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出图片上传列表
	 */
	@RequiresPermissions("llc:images:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Images images)
    {
    	List<Images> list = imagesService.selectImagesList(images);
        ExcelUtil<Images> util = new ExcelUtil<Images>(Images.class);
        return util.exportExcel(list, "images");
    }
	
	/**
	 * 新增图片上传
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
        Images files = new Images();
        mmap.put("files", files);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存图片上传
	 */
	@RequiresPermissions("llc:images:add")
	@Log(title = "图片上传", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MultipartFile file,Images images)
	{
        int rtn = 0;
        Boolean isFile = false;
        try {
            images = dealFile(file, images);
            //新增
            rtn = imagesService.insertImages(images);
            if (file != null ) {
                File desc = FileUploadUtils.getAbsoluteFile(Save_Url, images.getUrl());
                file.transferTo(desc);
            }
        } catch (Exception e) {
            log.error("保存失败，请检查后重试！", e);
            return error(e.getMessage());
        }
	    return toAjax(rtn);
	}
    private Images dealFile(MultipartFile file, Images files) throws Exception {
        //if (file == null || "2".equals(files.getType())) return files;
        if (file == null ){
            return files;
        }
        String suffix = FileUploadUtils.dealName(file.getOriginalFilename());
        if (StringUtils.isEmpty(suffix)){
            throw new Exception();
        }
        String name = Save_Url + files.getFileName() + "." + suffix;
        files.setUrl(name);
        files.setSuffix(suffix);
        return files;
    }
	/**
	 * 修改图片上传
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Images images = imagesService.selectImagesById(id);
		mmap.put("images", images);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存图片上传
	 */
	@RequiresPermissions("llc:images:edit")
	@Log(title = "图片上传", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Images images)
	{		
		return toAjax(imagesService.updateImages(images));
	}
	
	/**
	 * 删除图片上传
	 */
	@RequiresPermissions("llc:images:remove")
	@Log(title = "图片上传", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(imagesService.deleteImagesByIds(ids));
	}


    /**
     * 检验文件名是否唯一
     * @param files
     * @return
     */
    @PostMapping("/checkFileNameUnqiue")
    @ResponseBody
    public String checkFileNameUnqiue(Images files) {
        return imagesService.checkFileNameUnqiue(files);
    }

    /**
     * @Author haien
     * @Description 前端请求下载Excel表格，返回一个输出流
     * @Date 11:34 2018/7/22
     * @Param [request, response]
     * @return void
     **/
    @RequestMapping(value = "/getFileById")
    @Log(title = "文件下载", businessType = BusinessType.OTHER)
    @ResponseBody
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //获得请求文件名
        String encoding = System.getProperty("file.encoding");
        String idStr = request.getParameter("id");
        if(idStr==null||idStr.isEmpty()){
            System.out.println("file id not find!");
            return;
        }
        int id = Integer.parseInt(idStr);
        Images file =  imagesService.selectImagesById(id);
        if(file!=null&&file.getUrl()!=null){
            //设置Content-Disposition
            String enFileName = URLEncoder.encode(file.getFileName()+"."+file.getSuffix(),"utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+enFileName);
            //读取目标文件，通过response将目标文件写到客户端
            //读取文件
            String fileName = new String(file.getUrl().getBytes("UTF-8"),encoding);
            InputStream in = new FileInputStream(fileName);
            OutputStream out = response.getOutputStream();
            //写文件
            int b;
            while((b=in.read())!= -1) {
                out.write(b);
            }
            in.close();
            out.close();
        }

    }
	
}
