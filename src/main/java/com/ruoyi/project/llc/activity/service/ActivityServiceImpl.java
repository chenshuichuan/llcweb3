package com.ruoyi.project.llc.activity.service;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.activity.mapper.ActivityMapper;
import com.ruoyi.project.llc.activity.domain.Activity;
import com.ruoyi.project.llc.activity.service.IActivityService;
import com.ruoyi.common.support.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 活动管理 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class ActivityServiceImpl implements IActivityService 
{
	@Autowired
	private ActivityMapper activityMapper;

	/**
     * 查询活动管理信息
     * 
     * @param id 活动管理ID
     * @return 活动管理信息
     */
    @Override
	public Activity selectActivityById(Integer id)
	{
	    return activityMapper.selectActivityById(id);
	}
	
	/**
     * 查询活动管理列表
     * 
     * @param activity 活动管理信息
     * @return 活动管理集合
     */
	@Override
	public List<Activity> selectActivityList(Activity activity)
	{
//		if("admin".equals(ShiroUtils.getLoginName())){
//		}
//		else{
//			activity.setAuthor(ShiroUtils.getLoginName());
//		}
		return activityMapper.selectActivityList(activity);
	}
	
    /**
     * 新增活动管理
     * 
     * @param activity 活动管理信息
     * @return 结果
     */
	@Override
	@Transactional
	public int insertActivity(Activity activity)
	{
	    activity.setAuthor(ShiroUtils.getLoginName());
	    activity.setCreateTime(new Date());
	    activity.setUpdateTime(new Date());
		return activityMapper.insertActivity(activity);
	}
	
	/**
     * 修改活动管理
     * 
     * @param activity 活动管理信息
     * @return 结果
     */
	@Override
	@Transactional
	public int updateActivity(Activity activity)
	{
		activity.setAuthor(ShiroUtils.getLoginName());
		activity.setCreateTime(new Date());
		activity.setUpdateTime(new Date());
		return activityMapper.updateActivity(activity);
	}

	/**
     * 删除活动管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteActivityByIds(String ids)
	{
		return activityMapper.deleteActivityByIds(Convert.toStrArray(ids));
	}
	
}
