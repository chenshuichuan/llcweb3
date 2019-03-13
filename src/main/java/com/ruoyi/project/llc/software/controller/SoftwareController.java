package com.ruoyi.project.llc.software.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.llc.document.service.IDocumentService;
import com.ruoyi.project.system.files.service.IFilesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.ruoyi.project.llc.software.domain.Software;
import com.ruoyi.project.llc.software.service.ISoftwareService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 软著成果 信息操作处理
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/software")
public class SoftwareController extends BaseController {
    private String prefix = "llc/software";

    @Autowired
    private ISoftwareService softwareService;
    @Autowired
    private IDocumentService documentService;
    @Autowired
    private IFilesService filesService;

    @RequiresPermissions("llc:software:view")
    @GetMapping()
    public String software() {
        return prefix + "/software";
    }

    /**
     * 查询软著成果列表
     */
    @RequiresPermissions("llc:software:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Software software) {
        startPage();
        List<Software> list = softwareService.selectSoftwareList(software);
        return getDataTable(list);
    }


    /**
     * 导出软著成果列表
     */
    @RequiresPermissions("llc:software:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Software software) {
        List<Software> list = softwareService.selectSoftwareList(software);
        ExcelUtil<Software> util = new ExcelUtil<Software>(Software.class);
        return util.exportExcel(list, "software");
    }

    /**
     * 新增软著成果
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("documentList",documentService.getDocumentByAuthor(ShiroUtils.getLoginName()));
        mmap.put("FilesList",filesService.findByCreateByName(ShiroUtils.getLoginName()));
        return prefix + "/add";
    }

    /**
     * 新增保存软著成果
     */
    @RequiresPermissions("llc:software:add")
    @Log(title = "软著成果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Software software) {
        return toAjax(softwareService.insertSoftware(software));
    }

    /**
     * 修改软著成果
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Software software = softwareService.selectSoftwareById(id);
        mmap.put("software", software);
        mmap.put("documentList",documentService.getDocumentByAuthor(ShiroUtils.getLoginName()));
        mmap.put("FilesList",filesService.findByCreateByName(ShiroUtils.getLoginName()));
        return prefix + "/edit";
    }

    /**
     * 修改保存软著成果
     */
    @RequiresPermissions("llc:software:edit")
    @Log(title = "软著成果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Software software) {
        return toAjax(softwareService.updateSoftware(software));
    }

    /**
     * 删除软著成果
     */
    @RequiresPermissions("llc:software:remove")
    @Log(title = "软著成果", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(softwareService.deleteSoftwareByIds(ids));
    }

}
