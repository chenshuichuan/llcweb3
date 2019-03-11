package com.ruoyi.project.llc.paper.service;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.llc.paper.mapper.PaperMapper;
import com.ruoyi.project.llc.paper.domain.Paper;
import com.ruoyi.project.llc.paper.service.IPaperService;
import com.ruoyi.common.support.Convert;

/**
 * 论文成果 服务层实现
 * 
 * @author ricardo
 * @date 2019-03-09
 */
@Service
public class PaperServiceImpl implements IPaperService 
{
	@Autowired
	private PaperMapper paperMapper;

	/**
     * 查询论文成果信息
     * 
     * @param id 论文成果ID
     * @return 论文成果信息
     */
    @Override
	public Paper selectPaperById(Integer id)
	{
	    return paperMapper.selectPaperById(id);
	}
	
	/**
     * 查询论文成果列表
     * 
     * @param paper 论文成果信息
     * @return 论文成果集合
     */
	@Override
	public List<Paper> selectPaperList(Paper paper)
	{
	    return paperMapper.selectPaperList(paper);
	}
	
    /**
     * 新增论文成果
     * 
     * @param paper 论文成果信息
     * @return 结果
     */
	@Override
	public int insertPaper(Paper paper)
	{
		paper.setCreateTime(new Date());
		paper.setUpdateTime(new Date());
		return paperMapper.insertPaper(paper);
	}
	
	/**
     * 修改论文成果
     * 
     * @param paper 论文成果信息
     * @return 结果
     */
	@Override
	public int updatePaper(Paper paper)
	{

		paper.setUpdateTime(new Date());
		return paperMapper.updatePaper(paper);
	}

	/**
     * 删除论文成果对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePaperByIds(String ids)
	{
		return paperMapper.deletePaperByIds(Convert.toStrArray(ids));
	}
	
}
