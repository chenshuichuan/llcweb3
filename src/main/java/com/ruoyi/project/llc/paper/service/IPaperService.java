package com.ruoyi.project.llc.paper.service;

import com.ruoyi.project.llc.paper.domain.Paper;
import java.util.List;

/**
 * 论文成果 服务层
 * 
 * @author ricardo
 * @date 2019-03-09
 */
public interface IPaperService 
{
	/**
     * 查询论文成果信息
     * 
     * @param id 论文成果ID
     * @return 论文成果信息
     */
	public Paper selectPaperById(Integer id);
	
	/**
     * 查询论文成果列表
     * 
     * @param paper 论文成果信息
     * @return 论文成果集合
     */
	public List<Paper> selectPaperList(Paper paper);
	
	/**
     * 新增论文成果
     * 
     * @param paper 论文成果信息
     * @return 结果
     */
	public int insertPaper(Paper paper);
	
	/**
     * 修改论文成果
     * 
     * @param paper 论文成果信息
     * @return 结果
     */
	public int updatePaper(Paper paper);
		
	/**
     * 删除论文成果信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePaperByIds(String ids);
	
}
