package com.ruoyi.project.llc.people.controller;

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
import com.ruoyi.project.llc.people.domain.People;
import com.ruoyi.project.llc.people.service.IPeopleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 人员管理 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/people")
public class PeopleController extends BaseController
{
    private String prefix = "llc/people";
	
	@Autowired
	private IPeopleService peopleService;
	
	@RequiresPermissions("llc:people:view")
	@GetMapping()
	public String people()
	{
	    return prefix + "/people";
	}
	
	/**
	 * 查询人员管理列表
	 */
	@RequiresPermissions("llc:people:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(People people)
	{
		startPage();
        List<People> list = peopleService.selectPeopleList(people);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出人员管理列表
	 */
	@RequiresPermissions("llc:people:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(People people)
    {
    	List<People> list = peopleService.selectPeopleList(people);
        ExcelUtil<People> util = new ExcelUtil<People>(People.class);
        return util.exportExcel(list, "people");
    }
	
	/**
	 * 新增人员管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存人员管理
	 */
	@RequiresPermissions("llc:people:add")
	@Log(title = "人员管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(People people)
	{		
		return toAjax(peopleService.insertPeople(people));
	}

	/**
	 * 修改人员管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		People people = peopleService.selectPeopleById(id);
		mmap.put("people", people);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存人员管理
	 */
	@RequiresPermissions("llc:people:edit")
	@Log(title = "人员管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(People people)
	{		
		return toAjax(peopleService.updatePeople(people));
	}
	
	/**
	 * 删除人员管理
	 */
	@RequiresPermissions("llc:people:remove")
	@Log(title = "人员管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(peopleService.deletePeopleByIds(ids));
	}
	
}
