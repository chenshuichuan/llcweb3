package com.ruoyi.project.llc.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.project.mapper.ProjectMapper;
import com.ruoyi.project.llc.project.domain.Project;
import com.ruoyi.project.llc.project.service.IProjectService;
import com.ruoyi.common.support.Convert;

/**
 * 项目管理 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class ProjectServiceImpl implements IProjectService 
{
	@Autowired
	private ProjectMapper projectMapper;

	/**
     * 查询项目管理信息
     * 
     * @param id 项目管理ID
     * @return 项目管理信息
     */
    @Override
	public Project selectProjectById(Integer id)
	{
	    return projectMapper.selectProjectById(id);
	}
	
	/**
     * 查询项目管理列表
     * 
     * @param project 项目管理信息
     * @return 项目管理集合
     */
	@Override
	public List<Project> selectProjectList(Project project)
	{
	    return projectMapper.selectProjectList(project);
	}
	
    /**
     * 新增项目管理
     * 
     * @param project 项目管理信息
     * @return 结果
     */
	@Override
	public int insertProject(Project project)
	{
	    return projectMapper.insertProject(project);
	}
	
	/**
     * 修改项目管理
     * 
     * @param project 项目管理信息
     * @return 结果
     */
	@Override
	public int updateProject(Project project)
	{
	    return projectMapper.updateProject(project);
	}

	/**
     * 删除项目管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProjectByIds(String ids)
	{
		return projectMapper.deleteProjectByIds(Convert.toStrArray(ids));
	}
	
}
