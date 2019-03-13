package com.ruoyi.project.llc.document.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.llc.document.domain.DocumentInfor;
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

	@Autowired
	private DocumentRepository documentRepository;
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
	    //怎么放开更多权限？比如让非admin的其他管理员也能有查看所有人的文档的权限？
        if("admin".equals(ShiroUtils.getLoginName())){
        }
        else{
            document.setAuthor(ShiroUtils.getLoginName());
        }
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
		document.setAuthor(ShiroUtils.getLoginName());
		document.setCreateTime(new Date());
		document.setUpdateTime(new Date());
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
        document.setAuthor(ShiroUtils.getLoginName());
        document.setCreateTime(new Date());
        document.setUpdateTime(new Date());
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

	@Override
	public List<DocumentInfor> documentToDocuemntInfor(List<Document> documentList) {
		List<DocumentInfor> documentInforList = new ArrayList<>();
		for (Document document : documentList){
			DocumentInfor documentInfor = new DocumentInfor(document);
			documentInforList.add(documentInfor);
		}
		return documentInforList;
	}

	@Override
	public List<DocumentInfor> getDocumentByAuthor(String author) {
		List<Document> documentList = null ;
		if(!author.equals("admin")){
			documentList = documentRepository.findByAuthor(author);
		}
		else {
			documentList = documentRepository.findAll();
		}
		return documentToDocuemntInfor(documentList);
	}

}
