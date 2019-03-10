package com.ruoyi.project.llc.images.controller;

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
import com.ruoyi.project.llc.images.domain.Images;
import com.ruoyi.project.llc.images.service.IImagesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

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
    private String prefix = "llc/images";
	
	@Autowired
	private IImagesService imagesService;
	
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
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存图片上传
	 */
	@RequiresPermissions("llc:images:add")
	@Log(title = "图片上传", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Images images)
	{		
		return toAjax(imagesService.insertImages(images));
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
	
}
