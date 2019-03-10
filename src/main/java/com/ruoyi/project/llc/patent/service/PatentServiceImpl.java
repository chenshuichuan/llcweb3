package com.ruoyi.project.llc.patent.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.patent.mapper.PatentMapper;
import com.ruoyi.project.llc.patent.domain.Patent;
import com.ruoyi.project.llc.patent.service.IPatentService;
import com.ruoyi.common.support.Convert;

/**
 * 专利成果 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class PatentServiceImpl implements IPatentService 
{
	@Autowired
	private PatentMapper patentMapper;

	/**
     * 查询专利成果信息
     * 
     * @param id 专利成果ID
     * @return 专利成果信息
     */
    @Override
	public Patent selectPatentById(Integer id)
	{
	    return patentMapper.selectPatentById(id);
	}
	
	/**
     * 查询专利成果列表
     * 
     * @param patent 专利成果信息
     * @return 专利成果集合
     */
	@Override
	public List<Patent> selectPatentList(Patent patent)
	{
	    return patentMapper.selectPatentList(patent);
	}
	
    /**
     * 新增专利成果
     * 
     * @param patent 专利成果信息
     * @return 结果
     */
	@Override
	public int insertPatent(Patent patent)
	{
	    return patentMapper.insertPatent(patent);
	}
	
	/**
     * 修改专利成果
     * 
     * @param patent 专利成果信息
     * @return 结果
     */
	@Override
	public int updatePatent(Patent patent)
	{
	    return patentMapper.updatePatent(patent);
	}

	/**
     * 删除专利成果对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePatentByIds(String ids)
	{
		return patentMapper.deletePatentByIds(Convert.toStrArray(ids));
	}
	
}
