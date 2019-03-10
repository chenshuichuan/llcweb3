package com.ruoyi.project.llc.document1.controller;

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
import com.ruoyi.project.llc.document1.domain.Document1;
import com.ruoyi.project.llc.document1.service.IDocument1Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 原文档 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/document1")
public class Document1Controller extends BaseController
{
    private String prefix = "llc/document1";
	
	@Autowired
	private IDocument1Service document1Service;
	
	@RequiresPermissions("llc:document1:view")
	@GetMapping()
	public String document1()
	{
	    return prefix + "/document1";
	}
	
	/**
	 * 查询原文档列表
	 */
	@RequiresPermissions("llc:document1:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Document1 document1)
	{
		startPage();
        List<Document1> list = document1Service.selectDocument1List(document1);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出原文档列表
	 */
	@RequiresPermissions("llc:document1:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Document1 document1)
    {
    	List<Document1> list = document1Service.selectDocument1List(document1);
        ExcelUtil<Document1> util = new ExcelUtil<Document1>(Document1.class);
        return util.exportExcel(list, "document1");
    }
	
	/**
	 * 新增原文档
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存原文档
	 */
	@RequiresPermissions("llc:document1:add")
	@Log(title = "原文档", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Document1 document1)
	{		
		return toAjax(document1Service.insertDocument1(document1));
	}

	/**
	 * 修改原文档
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Document1 document1 = document1Service.selectDocument1ById(id);
		mmap.put("document1", document1);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存原文档
	 */
	@RequiresPermissions("llc:document1:edit")
	@Log(title = "原文档", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Document1 document1)
	{		
		return toAjax(document1Service.updateDocument1(document1));
	}
	
	/**
	 * 删除原文档
	 */
	@RequiresPermissions("llc:document1:remove")
	@Log(title = "原文档", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(document1Service.deleteDocument1ByIds(ids));
	}
	
}
