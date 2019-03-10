package com.ruoyi.project.llc.people.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.people.mapper.PeopleMapper;
import com.ruoyi.project.llc.people.domain.People;
import com.ruoyi.project.llc.people.service.IPeopleService;
import com.ruoyi.common.support.Convert;

/**
 * 人员管理 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class PeopleServiceImpl implements IPeopleService 
{
	@Autowired
	private PeopleMapper peopleMapper;

	/**
     * 查询人员管理信息
     * 
     * @param id 人员管理ID
     * @return 人员管理信息
     */
    @Override
	public People selectPeopleById(Integer id)
	{
	    return peopleMapper.selectPeopleById(id);
	}
	
	/**
     * 查询人员管理列表
     * 
     * @param people 人员管理信息
     * @return 人员管理集合
     */
	@Override
	public List<People> selectPeopleList(People people)
	{
	    return peopleMapper.selectPeopleList(people);
	}
	
    /**
     * 新增人员管理
     * 
     * @param people 人员管理信息
     * @return 结果
     */
	@Override
	public int insertPeople(People people)
	{
	    return peopleMapper.insertPeople(people);
	}
	
	/**
     * 修改人员管理
     * 
     * @param people 人员管理信息
     * @return 结果
     */
	@Override
	public int updatePeople(People people)
	{
	    return peopleMapper.updatePeople(people);
	}

	/**
     * 删除人员管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePeopleByIds(String ids)
	{
		return peopleMapper.deletePeopleByIds(Convert.toStrArray(ids));
	}
	
}
