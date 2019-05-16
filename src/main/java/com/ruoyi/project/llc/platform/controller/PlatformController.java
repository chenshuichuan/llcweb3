package com.ruoyi.project.llc.platform.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.llc.document.service.IDocumentService;
import com.ruoyi.project.system.files.service.IFilesService;
import io.swagger.annotations.Api;
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
import com.ruoyi.project.llc.platform.domain.Platform;
import com.ruoyi.project.llc.platform.service.IPlatformService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 实验室平台 信息操作处理
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Api("平台管理")
@Controller
@RequestMapping("/admin/llc/platform")
public class PlatformController extends BaseController {
    private String prefix = "llc/platform";

    @Autowired
    private IPlatformService platformService;
    @Autowired
    private IDocumentService documentService;
    @Autowired
    private IFilesService filesService;

    @RequiresPermissions("llc:platform:view")
    @GetMapping()
    public String platform() {
        return prefix + "/platform";
    }

    /**
     * 查询实验室平台列表
     */
    @RequiresPermissions("llc:platform:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Platform platform) {
        startPage();
        List<Platform> list = platformService.selectPlatformList(platform);
        return getDataTable(list);
    }


    /**
     * 导出实验室平台列表
     */
    @RequiresPermissions("llc:platform:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Platform platform) {
        List<Platform> list = platformService.selectPlatformList(platform);
        ExcelUtil<Platform> util = new ExcelUtil<Platform>(Platform.class);
        return util.exportExcel(list, "platform");
    }

    /**
     * 新增实验室平台
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("documentList", documentService.getDocumentByAuthor(ShiroUtils.getLoginName()));
        mmap.put("FilesList", filesService.findByCreateByName(ShiroUtils.getLoginName()));
        return prefix + "/add";
    }

    /**
     * 新增保存实验室平台
     */
    @RequiresPermissions("llc:platform:add")
    @Log(title = "实验室平台", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Platform platform) {
        return toAjax(platformService.insertPlatform(platform));
    }

    /**
     * 修改实验室平台
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Platform platform = platformService.selectPlatformById(id);
        mmap.put("platform", platform);
        return prefix + "/edit";
    }

    /**
     * 修改保存实验室平台
     */
    @RequiresPermissions("llc:platform:edit")
    @Log(title = "实验室平台", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Platform platform) {
        return toAjax(platformService.updatePlatform(platform));
    }

    /**
     * 删除实验室平台
     */
    @RequiresPermissions("llc:platform:remove")
    @Log(title = "实验室平台", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(platformService.deletePlatformByIds(ids));
    }

    /**
     *
     * */
    @GetMapping("/gaofen")
    public ModelAndView gaofen() {
        return new ModelAndView(new RedirectView("http://gdauto.gdut.edu.cn/gaofen/"));
    }
    /**
     *
     * */
    @GetMapping("/hpcomputing")
    public ModelAndView HPComputing() {
        return new ModelAndView(new RedirectView("http://gdauto.gdut.edu.cn/hpcomputing/"));
    }
}
