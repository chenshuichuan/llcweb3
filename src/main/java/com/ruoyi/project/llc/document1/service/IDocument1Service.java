package com.ruoyi.project.llc.document1.service;

import com.ruoyi.project.llc.document1.domain.Document1;
import java.util.List;

/**
 * 原文档 服务层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface IDocument1Service 
{
	/**
     * 查询原文档信息
     * 
     * @param id 原文档ID
     * @return 原文档信息
     */
	public Document1 selectDocument1ById(Integer id);
	
	/**
     * 查询原文档列表
     * 
     * @param document1 原文档信息
     * @return 原文档集合
     */
	public List<Document1> selectDocument1List(Document1 document1);
	
	/**
     * 新增原文档
     * 
     * @param document1 原文档信息
     * @return 结果
     */
	public int insertDocument1(Document1 document1);
	
	/**
     * 修改原文档
     * 
     * @param document1 原文档信息
     * @return 结果
     */
	public int updateDocument1(Document1 document1);
		
	/**
     * 删除原文档信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDocument1ByIds(String ids);
	
}
