package com.ruoyi.project.llc.images.service;

import com.ruoyi.project.llc.images.domain.Images;
import java.util.List;

/**
 * 图片上传 服务层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface IImagesService 
{
	/**
     * 查询图片上传信息
     * 
     * @param id 图片上传ID
     * @return 图片上传信息
     */
	public Images selectImagesById(Integer id);
	
	/**
     * 查询图片上传列表
     * 
     * @param images 图片上传信息
     * @return 图片上传集合
     */
	public List<Images> selectImagesList(Images images);
	
	/**
     * 新增图片上传
     * 
     * @param images 图片上传信息
     * @return 结果
     */
	public int insertImages(Images images);
	
	/**
     * 修改图片上传
     * 
     * @param images 图片上传信息
     * @return 结果
     */
	public int updateImages(Images images);
		
	/**
     * 删除图片上传信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteImagesByIds(String ids);
	
}
