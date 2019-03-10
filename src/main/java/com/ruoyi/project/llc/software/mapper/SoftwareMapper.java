package com.ruoyi.project.llc.software.mapper;

import com.ruoyi.project.llc.software.domain.Software;
import java.util.List;	

/**
 * 软著成果 数据层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface SoftwareMapper 
{
	/**
     * 查询软著成果信息
     * 
     * @param id 软著成果ID
     * @return 软著成果信息
     */
	public Software selectSoftwareById(Integer id);
	
	/**
     * 查询软著成果列表
     * 
     * @param software 软著成果信息
     * @return 软著成果集合
     */
	public List<Software> selectSoftwareList(Software software);
	
	/**
     * 新增软著成果
     * 
     * @param software 软著成果信息
     * @return 结果
     */
	public int insertSoftware(Software software);
	
	/**
     * 修改软著成果
     * 
     * @param software 软著成果信息
     * @return 结果
     */
	public int updateSoftware(Software software);
	
	/**
     * 删除软著成果
     * 
     * @param id 软著成果ID
     * @return 结果
     */
	public int deleteSoftwareById(Integer id);
	
	/**
     * 批量删除软著成果
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSoftwareByIds(String[] ids);
	
}