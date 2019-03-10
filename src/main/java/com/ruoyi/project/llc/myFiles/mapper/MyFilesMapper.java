package com.ruoyi.project.llc.myFiles.mapper;

import com.ruoyi.project.llc.myFiles.domain.MyFiles;
import java.util.List;	

/**
 * 文件上传 数据层
 * 
 * @author ricardo
 * @date 2019-03-10
 */
public interface MyFilesMapper 
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
     * 删除文件上传
     * 
     * @param id 文件上传ID
     * @return 结果
     */
	public int deleteMyFilesById(Integer id);
	
	/**
     * 批量删除文件上传
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMyFilesByIds(String[] ids);
	
}