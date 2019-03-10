package com.ruoyi.project.llc.files.controller;

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
import com.ruoyi.project.llc.files.domain.MyFiles;
import com.ruoyi.project.llc.files.service.IMyFilesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 文件上传 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/files")
public class MyFilesController extends BaseController
{
    private String prefix = "llc/files";
	
	@Autowired
	private IMyFilesService filesService;
	
	@RequiresPermissions("llc:files:view")
	@GetMapping()
	public String files()
	{
	    return prefix + "/files";
	}
	
	/**
	 * 查询文件上传列表
	 */
	@RequiresPermissions("llc:files:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MyFiles files)
	{
		startPage();
        List<MyFiles> list = filesService.selectFilesList(files);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出文件上传列表
	 */
	@RequiresPermissions("llc:files:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MyFiles files)
    {
    	List<MyFiles> list = filesService.selectFilesList(files);
        ExcelUtil<MyFiles> util = new ExcelUtil<MyFiles>(MyFiles.class);
        return util.exportExcel(list, "files");
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
	@RequiresPermissions("llc:files:add")
	@Log(title = "文件上传", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MyFiles files)
	{		
		return toAjax(filesService.insertFiles(files));
	}

	/**
	 * 修改文件上传
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		MyFiles files = filesService.selectFilesById(id);
		mmap.put("files", files);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文件上传
	 */
	@RequiresPermissions("llc:files:edit")
	@Log(title = "文件上传", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MyFiles files)
	{		
		return toAjax(filesService.updateFiles(files));
	}
	
	/**
	 * 删除文件上传
	 */
	@RequiresPermissions("llc:files:remove")
	@Log(title = "文件上传", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(filesService.deleteFilesByIds(ids));
	}
	
}
