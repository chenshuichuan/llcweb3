package com.ruoyi.project.llc.people.mapper;

import com.ruoyi.project.llc.people.domain.People;
import java.util.List;	

/**
 * 人员管理 数据层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface PeopleMapper 
{
	/**
     * 查询人员管理信息
     * 
     * @param id 人员管理ID
     * @return 人员管理信息
     */
	public People selectPeopleById(Integer id);
	
	/**
     * 查询人员管理列表
     * 
     * @param people 人员管理信息
     * @return 人员管理集合
     */
	public List<People> selectPeopleList(People people);
	
	/**
     * 新增人员管理
     * 
     * @param people 人员管理信息
     * @return 结果
     */
	public int insertPeople(People people);
	
	/**
     * 修改人员管理
     * 
     * @param people 人员管理信息
     * @return 结果
     */
	public int updatePeople(People people);
	
	/**
     * 删除人员管理
     * 
     * @param id 人员管理ID
     * @return 结果
     */
	public int deletePeopleById(Integer id);
	
	/**
     * 批量删除人员管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePeopleByIds(String[] ids);
	
}