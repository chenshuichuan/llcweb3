package com.ruoyi.project.llc.project.controller;

import java.util.List;
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
import com.ruoyi.project.llc.project.domain.Project;
import com.ruoyi.project.llc.project.service.IProjectService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 项目管理 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/project")
public class ProjectController extends BaseController
{
    private String prefix = "llc/project";
	
	@Autowired
	private IProjectService projectService;
	
	@RequiresPermissions("llc:project:view")
	@GetMapping()
	public String project()
	{
	    return prefix + "/project";
	}
	
	/**
	 * 查询项目管理列表
	 */
	@RequiresPermissions("llc:project:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Project project)
	{
		startPage();
        List<Project> list = projectService.selectProjectList(project);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出项目管理列表
	 */
	@RequiresPermissions("llc:project:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Project project)
    {
    	List<Project> list = projectService.selectProjectList(project);
        ExcelUtil<Project> util = new ExcelUtil<Project>(Project.class);
        return util.exportExcel(list, "project");
    }
	
	/**
	 * 新增项目管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存项目管理
	 */
	@RequiresPermissions("llc:project:add")
	@Log(title = "项目管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Project project)
	{		
		return toAjax(projectService.insertProject(project));
	}

	/**
	 * 修改项目管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Project project = projectService.selectProjectById(id);
		mmap.put("project", project);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目管理
	 */
	@RequiresPermissions("llc:project:edit")
	@Log(title = "项目管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Project project)
	{		
		return toAjax(projectService.updateProject(project));
	}
	
	/**
	 * 删除项目管理
	 */
	@RequiresPermissions("llc:project:remove")
	@Log(title = "项目管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(projectService.deleteProjectByIds(ids));
	}
	
}
