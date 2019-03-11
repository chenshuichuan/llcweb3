package com.ruoyi.project.llc.myFiles.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.myFiles.mapper.MyFilesMapper;
import com.ruoyi.project.llc.myFiles.domain.MyFiles;
import com.ruoyi.project.llc.myFiles.service.IMyFilesService;
import com.ruoyi.common.support.Convert;

/**
 * 文件上传 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-10
 */
@Service
public class MyFilesServiceImpl implements IMyFilesService
{
	@Autowired
	private MyFilesMapper myFilesMapper;

	/**
     * 查询文件上传信息
     * 
     * @param id 文件上传ID
     * @return 文件上传信息
     */
    @Override
	public MyFiles selectMyFilesById(Integer id)
	{
	    return myFilesMapper.selectMyFilesById(id);
	}
	
	/**
     * 查询文件上传列表
     * 
     * @param myFiles 文件上传信息
     * @return 文件上传集合
     */
	@Override
	public List<MyFiles> selectMyFilesList(MyFiles myFiles)
	{
	    return myFilesMapper.selectMyFilesList(myFiles);
	}
	
    /**
     * 新增文件上传
     * 
     * @param myFiles 文件上传信息
     * @return 结果
     */
	@Override
	public int insertMyFiles(MyFiles myFiles)
	{
	    return myFilesMapper.insertMyFiles(myFiles);
	}
	
	/**
     * 修改文件上传
     * 
     * @param myFiles 文件上传信息
     * @return 结果
     */
	@Override
	public int updateMyFiles(MyFiles myFiles)
	{
	    return myFilesMapper.updateMyFiles(myFiles);
	}

	/**
     * 删除文件上传对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMyFilesByIds(String ids)
	{
		return myFilesMapper.deleteMyFilesByIds(Convert.toStrArray(ids));
	}
	
}
