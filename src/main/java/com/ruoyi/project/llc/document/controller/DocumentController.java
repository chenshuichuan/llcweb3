package com.ruoyi.project.llc.document.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.llc.document.domain.DocumentInfor;
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
import com.ruoyi.project.llc.document.domain.Document;
import com.ruoyi.project.llc.document.service.IDocumentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 文档管理 信息操作处理
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Controller
@RequestMapping("/admin/llc/document")
public class DocumentController extends BaseController
{
    private String prefix = "llc/document";
	
	@Autowired
	private IDocumentService documentService;
	
	@RequiresPermissions("llc:document:view")
	@GetMapping()
	public String document()
	{
	    return prefix + "/document";
	}
	
	/**
	 * 查询文档管理列表
	 */
	@RequiresPermissions("llc:document:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Document document)
	{
		startPage();
        List<Document> list = documentService.selectDocumentList(document);
        List<DocumentInfor> documentInforList = documentService.documentToDocuemntInfor(list);
		return getDataTable(documentInforList);
	}
	
	
	/**
	 * 导出文档管理列表
	 */
	@RequiresPermissions("llc:document:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Document document)
    {
    	List<Document> list = documentService.selectDocumentList(document);
        ExcelUtil<Document> util = new ExcelUtil<Document>(Document.class);
        return util.exportExcel(list, "document");
    }
	/**
	 * 获取文档
	 */
	@GetMapping("/getDocumentList")
	@ResponseBody
	public List<DocumentInfor> getDocumentList()
	{
		return documentService.getDocumentByAuthor(ShiroUtils.getLoginName());
	}
	/**
	 * 获取文档
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Document getDocument(@PathVariable("id") Integer id)
	{
		return documentService.selectDocumentById(id);
	}
	/**
	 * 新增文档管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文档管理
	 */
	@RequiresPermissions("llc:document:add")
	@Log(title = "文档管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Document document)
	{		
		return toAjax(documentService.insertDocument(document));
	}

	/**
	 * 修改文档管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Document document = documentService.selectDocumentById(id);
		mmap.put("document", document);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文档管理
	 */
	@RequiresPermissions("llc:document:edit")
	@Log(title = "文档管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Document document)
	{		
		return toAjax(documentService.updateDocument(document));
	}
	
	/**
	 * 删除文档管理
	 */
	@RequiresPermissions("llc:document:remove")
	@Log(title = "文档管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(documentService.deleteDocumentByIds(ids));
	}


	
}
