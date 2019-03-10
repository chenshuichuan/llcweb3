package com.ruoyi.project.llc.platform.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.platform.mapper.PlatformMapper;
import com.ruoyi.project.llc.platform.domain.Platform;
import com.ruoyi.project.llc.platform.service.IPlatformService;
import com.ruoyi.common.support.Convert;

/**
 * 实验室平台 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class PlatformServiceImpl implements IPlatformService 
{
	@Autowired
	private PlatformMapper platformMapper;

	/**
     * 查询实验室平台信息
     * 
     * @param id 实验室平台ID
     * @return 实验室平台信息
     */
    @Override
	public Platform selectPlatformById(Integer id)
	{
	    return platformMapper.selectPlatformById(id);
	}
	
	/**
     * 查询实验室平台列表
     * 
     * @param platform 实验室平台信息
     * @return 实验室平台集合
     */
	@Override
	public List<Platform> selectPlatformList(Platform platform)
	{
	    return platformMapper.selectPlatformList(platform);
	}
	
    /**
     * 新增实验室平台
     * 
     * @param platform 实验室平台信息
     * @return 结果
     */
	@Override
	public int insertPlatform(Platform platform)
	{
	    return platformMapper.insertPlatform(platform);
	}
	
	/**
     * 修改实验室平台
     * 
     * @param platform 实验室平台信息
     * @return 结果
     */
	@Override
	public int updatePlatform(Platform platform)
	{
	    return platformMapper.updatePlatform(platform);
	}

	/**
     * 删除实验室平台对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePlatformByIds(String ids)
	{
		return platformMapper.deletePlatformByIds(Convert.toStrArray(ids));
	}
	
}
