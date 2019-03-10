package com.ruoyi.project.llc.software.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.software.mapper.SoftwareMapper;
import com.ruoyi.project.llc.software.domain.Software;
import com.ruoyi.project.llc.software.service.ISoftwareService;
import com.ruoyi.common.support.Convert;

/**
 * 软著成果 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class SoftwareServiceImpl implements ISoftwareService 
{
	@Autowired
	private SoftwareMapper softwareMapper;

	/**
     * 查询软著成果信息
     * 
     * @param id 软著成果ID
     * @return 软著成果信息
     */
    @Override
	public Software selectSoftwareById(Integer id)
	{
	    return softwareMapper.selectSoftwareById(id);
	}
	
	/**
     * 查询软著成果列表
     * 
     * @param software 软著成果信息
     * @return 软著成果集合
     */
	@Override
	public List<Software> selectSoftwareList(Software software)
	{
	    return softwareMapper.selectSoftwareList(software);
	}
	
    /**
     * 新增软著成果
     * 
     * @param software 软著成果信息
     * @return 结果
     */
	@Override
	public int insertSoftware(Software software)
	{
	    return softwareMapper.insertSoftware(software);
	}
	
	/**
     * 修改软著成果
     * 
     * @param software 软著成果信息
     * @return 结果
     */
	@Override
	public int updateSoftware(Software software)
	{
	    return softwareMapper.updateSoftware(software);
	}

	/**
     * 删除软著成果对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSoftwareByIds(String ids)
	{
		return softwareMapper.deleteSoftwareByIds(Convert.toStrArray(ids));
	}
	
}
