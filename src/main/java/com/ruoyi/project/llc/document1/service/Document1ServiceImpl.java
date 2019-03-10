package com.ruoyi.project.llc.document1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.document1.mapper.Document1Mapper;
import com.ruoyi.project.llc.document1.domain.Document1;
import com.ruoyi.project.llc.document1.service.IDocument1Service;
import com.ruoyi.common.support.Convert;

/**
 * 原文档 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class Document1ServiceImpl implements IDocument1Service 
{
	@Autowired
	private Document1Mapper document1Mapper;

	/**
     * 查询原文档信息
     * 
     * @param id 原文档ID
     * @return 原文档信息
     */
    @Override
	public Document1 selectDocument1ById(Integer id)
	{
	    return document1Mapper.selectDocument1ById(id);
	}
	
	/**
     * 查询原文档列表
     * 
     * @param document1 原文档信息
     * @return 原文档集合
     */
	@Override
	public List<Document1> selectDocument1List(Document1 document1)
	{
	    return document1Mapper.selectDocument1List(document1);
	}
	
    /**
     * 新增原文档
     * 
     * @param document1 原文档信息
     * @return 结果
     */
	@Override
	public int insertDocument1(Document1 document1)
	{
	    return document1Mapper.insertDocument1(document1);
	}
	
	/**
     * 修改原文档
     * 
     * @param document1 原文档信息
     * @return 结果
     */
	@Override
	public int updateDocument1(Document1 document1)
	{
	    return document1Mapper.updateDocument1(document1);
	}

	/**
     * 删除原文档对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDocument1ByIds(String ids)
	{
		return document1Mapper.deleteDocument1ByIds(Convert.toStrArray(ids));
	}
	
}
