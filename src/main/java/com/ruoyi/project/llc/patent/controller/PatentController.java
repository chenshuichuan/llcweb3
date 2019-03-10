package com.ruoyi.project.llc.patent.controller;

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
import com.ruoyi.project.llc.patent.domain.Patent;
import com.ruoyi.project.llc.patent.service.IPatentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 专利成果 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/patent")
public class PatentController extends BaseController
{
    private String prefix = "llc/patent";
	
	@Autowired
	private IPatentService patentService;
	
	@RequiresPermissions("llc:patent:view")
	@GetMapping()
	public String patent()
	{
	    return prefix + "/patent";
	}
	
	/**
	 * 查询专利成果列表
	 */
	@RequiresPermissions("llc:patent:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Patent patent)
	{
		startPage();
        List<Patent> list = patentService.selectPatentList(patent);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出专利成果列表
	 */
	@RequiresPermissions("llc:patent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Patent patent)
    {
    	List<Patent> list = patentService.selectPatentList(patent);
        ExcelUtil<Patent> util = new ExcelUtil<Patent>(Patent.class);
        return util.exportExcel(list, "patent");
    }
	
	/**
	 * 新增专利成果
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存专利成果
	 */
	@RequiresPermissions("llc:patent:add")
	@Log(title = "专利成果", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Patent patent)
	{		
		return toAjax(patentService.insertPatent(patent));
	}

	/**
	 * 修改专利成果
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Patent patent = patentService.selectPatentById(id);
		mmap.put("patent", patent);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存专利成果
	 */
	@RequiresPermissions("llc:patent:edit")
	@Log(title = "专利成果", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Patent patent)
	{		
		return toAjax(patentService.updatePatent(patent));
	}
	
	/**
	 * 删除专利成果
	 */
	@RequiresPermissions("llc:patent:remove")
	@Log(title = "专利成果", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(patentService.deletePatentByIds(ids));
	}
	
}
