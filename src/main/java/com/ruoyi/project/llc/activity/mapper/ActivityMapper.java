package com.ruoyi.project.llc.activity.mapper;

import com.ruoyi.project.llc.activity.domain.Activity;
import java.util.List;	

/**
 * 活动管理 数据层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface ActivityMapper 
{
	/**
     * 查询活动管理信息
     * 
     * @param id 活动管理ID
     * @return 活动管理信息
     */
	public Activity selectActivityById(Integer id);
	
	/**
     * 查询活动管理列表
     * 
     * @param activity 活动管理信息
     * @return 活动管理集合
     */
	public List<Activity> selectActivityList(Activity activity);
	
	/**
     * 新增活动管理
     * 
     * @param activity 活动管理信息
     * @return 结果
     */
	public int insertActivity(Activity activity);
	
	/**
     * 修改活动管理
     * 
     * @param activity 活动管理信息
     * @return 结果
     */
	public int updateActivity(Activity activity);
	
	/**
     * 删除活动管理
     * 
     * @param id 活动管理ID
     * @return 结果
     */
	public int deleteActivityById(Integer id);
	
	/**
     * 批量删除活动管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteActivityByIds(String[] ids);
	
}