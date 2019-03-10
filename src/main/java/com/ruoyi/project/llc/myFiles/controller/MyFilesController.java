package com.ruoyi.project.llc.myFiles.controller;

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
import com.ruoyi.project.llc.myFiles.domain.MyFiles;
import com.ruoyi.project.llc.myFiles.service.IMyFilesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 文件上传 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-10
 */
@Controller
@RequestMapping("/admin/llc/myFiles")
public class MyFilesController extends BaseController
{
    private String prefix = "llc/myFiles";
	
	@Autowired
	private IMyFilesService myFilesService;
	
	@RequiresPermissions("llc:myFiles:view")
	@GetMapping()
	public String myFiles()
	{
	    return prefix + "/myFiles";
	}
	
	/**
	 * 查询文件上传列表
	 */
	@RequiresPermissions("llc:myFiles:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MyFiles myFiles)
	{
		startPage();
        List<MyFiles> list = myFilesService.selectMyFilesList(myFiles);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出文件上传列表
	 */
	@RequiresPermissions("llc:myFiles:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MyFiles myFiles)
    {
    	List<MyFiles> list = myFilesService.selectMyFilesList(myFiles);
        ExcelUtil<MyFiles> util = new ExcelUtil<MyFiles>(MyFiles.class);
        return util.exportExcel(list, "myFiles");
    }
	
	/**
	 * 新增文件上传
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文件上传
	 */
	@RequiresPermissions("llc:myFiles:add")
	@Log(title = "文件上传", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MyFiles myFiles)
	{		
		return toAjax(myFilesService.insertMyFiles(myFiles));
	}

	/**
	 * 修改文件上传
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		MyFiles myFiles = myFilesService.selectMyFilesById(id);
		mmap.put("myFiles", myFiles);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文件上传
	 */
	@RequiresPermissions("llc:myFiles:edit")
	@Log(title = "文件上传", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MyFiles myFiles)
	{		
		return toAjax(myFilesService.updateMyFiles(myFiles));
	}
	
	/**
	 * 删除文件上传
	 */
	@RequiresPermissions("llc:myFiles:remove")
	@Log(title = "文件上传", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(myFilesService.deleteMyFilesByIds(ids));
	}
	
}
