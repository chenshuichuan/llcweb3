package com.ruoyi.project.llc.files.mapper;

import com.ruoyi.project.llc.files.domain.MyFiles;
import java.util.List;	

/**
 * 文件上传 数据层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface MyFilesMapper
{
	/**
     * 查询文件上传信息
     * 
     * @param id 文件上传ID
     * @return 文件上传信息
     */
	public MyFiles selectFilesById(Integer id);
	
	/**
     * 查询文件上传列表
     * 
     * @param files 文件上传信息
     * @return 文件上传集合
     */
	public List<MyFiles> selectFilesList(MyFiles files);
	
	/**
     * 新增文件上传
     * 
     * @param files 文件上传信息
     * @return 结果
     */
	public int insertFiles(MyFiles files);
	
	/**
     * 修改文件上传
     * 
     * @param files 文件上传信息
     * @return 结果
     */
	public int updateFiles(MyFiles files);
	
	/**
     * 删除文件上传
     * 
     * @param id 文件上传ID
     * @return 结果
     */
	public int deleteFilesById(Integer id);
	
	/**
     * 批量删除文件上传
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFilesByIds(String[] ids);
	
}