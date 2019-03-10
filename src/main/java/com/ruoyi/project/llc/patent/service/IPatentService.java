package com.ruoyi.project.llc.patent.service;

import com.ruoyi.project.llc.patent.domain.Patent;
import java.util.List;

/**
 * 专利成果 服务层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface IPatentService 
{
	/**
     * 查询专利成果信息
     * 
     * @param id 专利成果ID
     * @return 专利成果信息
     */
	public Patent selectPatentById(Integer id);
	
	/**
     * 查询专利成果列表
     * 
     * @param patent 专利成果信息
     * @return 专利成果集合
     */
	public List<Patent> selectPatentList(Patent patent);
	
	/**
     * 新增专利成果
     * 
     * @param patent 专利成果信息
     * @return 结果
     */
	public int insertPatent(Patent patent);
	
	/**
     * 修改专利成果
     * 
     * @param patent 专利成果信息
     * @return 结果
     */
	public int updatePatent(Patent patent);
		
	/**
     * 删除专利成果信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePatentByIds(String ids);
	
}
