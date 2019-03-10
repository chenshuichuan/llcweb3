package com.ruoyi.project.llc.myFiles.service;

import com.ruoyi.project.llc.myFiles.domain.MyFiles;
import java.util.List;

/**
 * 文件上传 服务层
 * 
 * @author ricardo
 * @date 2019-03-10
 */
public interface IMyFilesService 
{
	/**
     * 查询文件上传信息
     * 
     * @param id 文件上传ID
     * @return 文件上传信息
     */
	public MyFiles selectMyFilesById(Integer id);
	
	/**
     * 查询文件上传列表
     * 
     * @param myFiles 文件上传信息
     * @return 文件上传集合
     */
	public List<MyFiles> selectMyFilesList(MyFiles myFiles);
	
	/**
     * 新增文件上传
     * 
     * @param myFiles 文件上传信息
     * @return 结果
     */
	public int insertMyFiles(MyFiles myFiles);
	
	/**
     * 修改文件上传
     * 
     * @param myFiles 文件上传信息
     * @return 结果
     */
	public int updateMyFiles(MyFiles myFiles);
		
	/**
     * 删除文件上传信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMyFilesByIds(String ids);
	
}
