package com.ruoyi.project.llc.comments.mapper;

import com.ruoyi.project.llc.comments.domain.Comments;
import java.util.List;	

/**
 * 访客留言 数据层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface CommentsMapper 
{
	/**
     * 查询访客留言信息
     * 
     * @param id 访客留言ID
     * @return 访客留言信息
     */
	public Comments selectCommentsById(Integer id);
	
	/**
     * 查询访客留言列表
     * 
     * @param comments 访客留言信息
     * @return 访客留言集合
     */
	public List<Comments> selectCommentsList(Comments comments);
	
	/**
     * 新增访客留言
     * 
     * @param comments 访客留言信息
     * @return 结果
     */
	public int insertComments(Comments comments);
	
	/**
     * 修改访客留言
     * 
     * @param comments 访客留言信息
     * @return 结果
     */
	public int updateComments(Comments comments);
	
	/**
     * 删除访客留言
     * 
     * @param id 访客留言ID
     * @return 结果
     */
	public int deleteCommentsById(Integer id);
	
	/**
     * 批量删除访客留言
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCommentsByIds(String[] ids);
	
}