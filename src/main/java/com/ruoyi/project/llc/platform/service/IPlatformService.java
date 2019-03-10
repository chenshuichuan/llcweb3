package com.ruoyi.project.llc.platform.service;

import com.ruoyi.project.llc.platform.domain.Platform;
import java.util.List;

/**
 * 实验室平台 服务层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface IPlatformService 
{
	/**
     * 查询实验室平台信息
     * 
     * @param id 实验室平台ID
     * @return 实验室平台信息
     */
	public Platform selectPlatformById(Integer id);
	
	/**
     * 查询实验室平台列表
     * 
     * @param platform 实验室平台信息
     * @return 实验室平台集合
     */
	public List<Platform> selectPlatformList(Platform platform);
	
	/**
     * 新增实验室平台
     * 
     * @param platform 实验室平台信息
     * @return 结果
     */
	public int insertPlatform(Platform platform);
	
	/**
     * 修改实验室平台
     * 
     * @param platform 实验室平台信息
     * @return 结果
     */
	public int updatePlatform(Platform platform);
		
	/**
     * 删除实验室平台信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePlatformByIds(String ids);
	
}
