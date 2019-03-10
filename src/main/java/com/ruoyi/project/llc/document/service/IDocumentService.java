package com.ruoyi.project.llc.document.service;

import com.ruoyi.project.llc.document.domain.Document;
import java.util.List;

/**
 * 文档管理 服务层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface IDocumentService 
{
	/**
     * 查询文档管理信息
     * 
     * @param id 文档管理ID
     * @return 文档管理信息
     */
	public Document selectDocumentById(Integer id);
	
	/**
     * 查询文档管理列表
     * 
     * @param document 文档管理信息
     * @return 文档管理集合
     */
	public List<Document> selectDocumentList(Document document);
	
	/**
     * 新增文档管理
     * 
     * @param document 文档管理信息
     * @return 结果
     */
	public int insertDocument(Document document);
	
	/**
     * 修改文档管理
     * 
     * @param document 文档管理信息
     * @return 结果
     */
	public int updateDocument(Document document);
		
	/**
     * 删除文档管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDocumentByIds(String ids);
	
}
