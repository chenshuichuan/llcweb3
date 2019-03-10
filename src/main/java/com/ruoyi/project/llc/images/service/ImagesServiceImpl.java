package com.ruoyi.project.llc.images.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.images.mapper.ImagesMapper;
import com.ruoyi.project.llc.images.domain.Images;
import com.ruoyi.project.llc.images.service.IImagesService;
import com.ruoyi.common.support.Convert;

/**
 * 图片上传 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class ImagesServiceImpl implements IImagesService 
{
	@Autowired
	private ImagesMapper imagesMapper;

	/**
     * 查询图片上传信息
     * 
     * @param id 图片上传ID
     * @return 图片上传信息
     */
    @Override
	public Images selectImagesById(Integer id)
	{
	    return imagesMapper.selectImagesById(id);
	}
	
	/**
     * 查询图片上传列表
     * 
     * @param images 图片上传信息
     * @return 图片上传集合
     */
	@Override
	public List<Images> selectImagesList(Images images)
	{
	    return imagesMapper.selectImagesList(images);
	}
	
    /**
     * 新增图片上传
     * 
     * @param images 图片上传信息
     * @return 结果
     */
	@Override
	public int insertImages(Images images)
	{
	    return imagesMapper.insertImages(images);
	}
	
	/**
     * 修改图片上传
     * 
     * @param images 图片上传信息
     * @return 结果
     */
	@Override
	public int updateImages(Images images)
	{
	    return imagesMapper.updateImages(images);
	}

	/**
     * 删除图片上传对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteImagesByIds(String ids)
	{
		return imagesMapper.deleteImagesByIds(Convert.toStrArray(ids));
	}
	
}
