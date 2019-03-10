package com.ruoyi.project.llc.project.service;

import com.ruoyi.project.llc.project.domain.Project;
import java.util.List;

/**
 * 项目管理 服务层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface IProjectService 
{
	/**
     * 查询项目管理信息
     * 
     * @param id 项目管理ID
     * @return 项目管理信息
     */
	public Project selectProjectById(Integer id);
	
	/**
     * 查询项目管理列表
     * 
     * @param project 项目管理信息
     * @return 项目管理集合
     */
	public List<Project> selectProjectList(Project project);
	
	/**
     * 新增项目管理
     * 
     * @param project 项目管理信息
     * @return 结果
     */
	public int insertProject(Project project);
	
	/**
     * 修改项目管理
     * 
     * @param project 项目管理信息
     * @return 结果
     */
	public int updateProject(Project project);
		
	/**
     * 删除项目管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProjectByIds(String ids);
	
}
