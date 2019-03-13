package com.ruoyi.project.llc.activity.controller;

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
import com.ruoyi.project.llc.activity.domain.Activity;
import com.ruoyi.project.llc.activity.service.IActivityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 活动管理 信息操作处理
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/activity")
public class ActivityController extends BaseController {
    private String prefix = "llc/activity";

    @Autowired
    private IActivityService activityService;
    @Autowired
    private IDocumentService documentService;
    @Autowired
    private IFilesService filesService;

    @RequiresPermissions("llc:activity:view")
    @GetMapping()
    public String activity() {
        return prefix + "/activity";
    }

    /**
     * 查询活动管理列表
     */
    @RequiresPermissions("llc:activity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Activity activity) {
        startPage();
        List<Activity> list = activityService.selectActivityList(activity);
        return getDataTable(list);
    }


    /**
     * 导出活动管理列表
     */
    @RequiresPermissions("llc:activity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Activity activity) {
        List<Activity> list = activityService.selectActivityList(activity);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        return util.exportExcel(list, "activity");
    }

    /**
     * 新增活动管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("documentList",documentService.getDocumentByAuthor(ShiroUtils.getLoginName()));
        mmap.put("FilesList",filesService.findByCreateByName(ShiroUtils.getLoginName()));

        return prefix + "/add";
    }

    /**
     * 新增保存活动管理
     */
    @RequiresPermissions("llc:activity:add")
    @Log(title = "活动管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Activity activity) {
        return toAjax(activityService.insertActivity(activity));
    }

    /**
     * 修改活动管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Activity activity = activityService.selectActivityById(id);
        mmap.put("activity", activity);
        mmap.put("documentList",documentService.getDocumentByAuthor(ShiroUtils.getLoginName()));
        mmap.put("FilesList",filesService.findByCreateByName(ShiroUtils.getLoginName()));

        return prefix + "/edit";
    }

    /**
     * 修改保存活动管理
     */
    @RequiresPermissions("llc:activity:edit")
    @Log(title = "活动管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Activity activity) {
        return toAjax(activityService.updateActivity(activity));
    }

    /**
     * 删除活动管理
     */
    @RequiresPermissions("llc:activity:remove")
    @Log(title = "活动管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(activityService.deleteActivityByIds(ids));
    }

}
