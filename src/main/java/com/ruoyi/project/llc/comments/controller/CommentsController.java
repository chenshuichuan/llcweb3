package com.ruoyi.project.llc.comments.controller;

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
import com.ruoyi.project.llc.comments.domain.Comments;
import com.ruoyi.project.llc.comments.service.ICommentsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 访客留言 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/comments")
public class CommentsController extends BaseController
{
    private String prefix = "llc/comments";
	
	@Autowired
	private ICommentsService commentsService;
	
	@RequiresPermissions("llc:comments:view")
	@GetMapping()
	public String comments()
	{
	    return prefix + "/comments";
	}
	
	/**
	 * 查询访客留言列表
	 */
	@RequiresPermissions("llc:comments:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Comments comments)
	{
		startPage();
        List<Comments> list = commentsService.selectCommentsList(comments);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出访客留言列表
	 */
	@RequiresPermissions("llc:comments:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Comments comments)
    {
    	List<Comments> list = commentsService.selectCommentsList(comments);
        ExcelUtil<Comments> util = new ExcelUtil<Comments>(Comments.class);
        return util.exportExcel(list, "comments");
    }
	
	/**
	 * 新增访客留言
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存访客留言
	 */
	@RequiresPermissions("llc:comments:add")
	@Log(title = "访客留言", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Comments comments)
	{		
		return toAjax(commentsService.insertComments(comments));
	}

	/**
	 * 修改访客留言
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Comments comments = commentsService.selectCommentsById(id);
		mmap.put("comments", comments);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存访客留言
	 */
	@RequiresPermissions("llc:comments:edit")
	@Log(title = "访客留言", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Comments comments)
	{		
		return toAjax(commentsService.updateComments(comments));
	}
	
	/**
	 * 删除访客留言
	 */
	@RequiresPermissions("llc:comments:remove")
	@Log(title = "访客留言", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(commentsService.deleteCommentsByIds(ids));
	}
	
}
