package com.ruoyi.project.llc.document.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.document.mapper.DocumentMapper;
import com.ruoyi.project.llc.document.domain.Document;
import com.ruoyi.project.llc.document.service.IDocumentService;
import com.ruoyi.common.support.Convert;

/**
 * 文档管理 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class DocumentServiceImpl implements IDocumentService 
{
	@Autowired
	private DocumentMapper documentMapper;

	/**
     * 查询文档管理信息
     * 
     * @param id 文档管理ID
     * @return 文档管理信息
     */
    @Override
	public Document selectDocumentById(Integer id)
	{
	    return documentMapper.selectDocumentById(id);
	}
	
	/**
     * 查询文档管理列表
     * 
     * @param document 文档管理信息
     * @return 文档管理集合
     */
	@Override
	public List<Document> selectDocumentList(Document document)
	{
	    return documentMapper.selectDocumentList(document);
	}
	
    /**
     * 新增文档管理
     * 
     * @param document 文档管理信息
     * @return 结果
     */
	@Override
	public int insertDocument(Document document)
	{
	    return documentMapper.insertDocument(document);
	}
	
	/**
     * 修改文档管理
     * 
     * @param document 文档管理信息
     * @return 结果
     */
	@Override
	public int updateDocument(Document document)
	{
	    return documentMapper.updateDocument(document);
	}

	/**
     * 删除文档管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDocumentByIds(String ids)
	{
		return documentMapper.deleteDocumentByIds(Convert.toStrArray(ids));
	}
	
}
