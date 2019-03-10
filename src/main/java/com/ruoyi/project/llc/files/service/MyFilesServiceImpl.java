package com.ruoyi.project.llc.files.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.files.mapper.MyFilesMapper;
import com.ruoyi.project.llc.files.domain.MyFiles;
import com.ruoyi.common.support.Convert;

/**
 * 文件上传 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class MyFilesServiceImpl implements IMyFilesService
{
	@Autowired
	private MyFilesMapper filesMapper;

	/**
     * 查询文件上传信息
     * 
     * @param id 文件上传ID
     * @return 文件上传信息
     */
    @Override
	public MyFiles selectFilesById(Integer id)
	{
	    return filesMapper.selectFilesById(id);
	}
	
	/**
     * 查询文件上传列表
     * 
     * @param files 文件上传信息
     * @return 文件上传集合
     */
	@Override
	public List<MyFiles> selectFilesList(MyFiles files)
	{
	    return filesMapper.selectFilesList(files);
	}
	
    /**
     * 新增文件上传
     * 
     * @param files 文件上传信息
     * @return 结果
     */
	@Override
	public int insertFiles(MyFiles files)
	{
	    return filesMapper.insertFiles(files);
	}
	
	/**
     * 修改文件上传
     * 
     * @param files 文件上传信息
     * @return 结果
     */
	@Override
	public int updateFiles(MyFiles files)
	{
	    return filesMapper.updateFiles(files);
	}

	/**
     * 删除文件上传对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFilesByIds(String ids)
	{
		return filesMapper.deleteFilesByIds(Convert.toStrArray(ids));
	}
	
}
