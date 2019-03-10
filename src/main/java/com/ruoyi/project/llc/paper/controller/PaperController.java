package com.ruoyi.project.llc.paper.controller;

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
import com.ruoyi.project.llc.paper.domain.Paper;
import com.ruoyi.project.llc.paper.service.IPaperService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 论文成果 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/paper")
public class PaperController extends BaseController
{
    private String prefix = "llc/paper";
	
	@Autowired
	private IPaperService paperService;
	
	@RequiresPermissions("llc:paper:view")
	@GetMapping()
	public String paper()
	{
	    return prefix + "/paper";
	}
	
	/**
	 * 查询论文成果列表
	 */
	@RequiresPermissions("llc:paper:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Paper paper)
	{
		startPage();
        List<Paper> list = paperService.selectPaperList(paper);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出论文成果列表
	 */
	@RequiresPermissions("llc:paper:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Paper paper)
    {
    	List<Paper> list = paperService.selectPaperList(paper);
        ExcelUtil<Paper> util = new ExcelUtil<Paper>(Paper.class);
        return util.exportExcel(list, "paper");
    }
	
	/**
	 * 新增论文成果
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存论文成果
	 */
	@RequiresPermissions("llc:paper:add")
	@Log(title = "论文成果", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Paper paper)
	{		
		return toAjax(paperService.insertPaper(paper));
	}

	/**
	 * 修改论文成果
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Paper paper = paperService.selectPaperById(id);
		mmap.put("paper", paper);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存论文成果
	 */
	@RequiresPermissions("llc:paper:edit")
	@Log(title = "论文成果", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Paper paper)
	{		
		return toAjax(paperService.updatePaper(paper));
	}
	
	/**
	 * 删除论文成果
	 */
	@RequiresPermissions("llc:paper:remove")
	@Log(title = "论文成果", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(paperService.deletePaperByIds(ids));
	}
	
}
