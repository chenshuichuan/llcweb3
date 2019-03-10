package com.ruoyi.project.llc.comments.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.comments.mapper.CommentsMapper;
import com.ruoyi.project.llc.comments.domain.Comments;
import com.ruoyi.project.llc.comments.service.ICommentsService;
import com.ruoyi.common.support.Convert;

/**
 * 访客留言 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class CommentsServiceImpl implements ICommentsService 
{
	@Autowired
	private CommentsMapper commentsMapper;

	/**
     * 查询访客留言信息
     * 
     * @param id 访客留言ID
     * @return 访客留言信息
     */
    @Override
	public Comments selectCommentsById(Integer id)
	{
	    return commentsMapper.selectCommentsById(id);
	}
	
	/**
     * 查询访客留言列表
     * 
     * @param comments 访客留言信息
     * @return 访客留言集合
     */
	@Override
	public List<Comments> selectCommentsList(Comments comments)
	{
	    return commentsMapper.selectCommentsList(comments);
	}
	
    /**
     * 新增访客留言
     * 
     * @param comments 访客留言信息
     * @return 结果
     */
	@Override
	public int insertComments(Comments comments)
	{
	    return commentsMapper.insertComments(comments);
	}
	
	/**
     * 修改访客留言
     * 
     * @param comments 访客留言信息
     * @return 结果
     */
	@Override
	public int updateComments(Comments comments)
	{
	    return commentsMapper.updateComments(comments);
	}

	/**
     * 删除访客留言对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCommentsByIds(String ids)
	{
		return commentsMapper.deleteCommentsByIds(Convert.toStrArray(ids));
	}
	
}
