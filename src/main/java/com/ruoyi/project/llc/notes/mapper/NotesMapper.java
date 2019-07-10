package com.ruoyi.project.llc.notes.mapper;

import com.ruoyi.project.llc.notes.domain.Notes;

import java.util.List;

public interface NotesMapper {
    /**
     * @Author haien
     * @Description 查询指定笔记
     * @Date 2019/7/7
     * @Param [id]
     * @return Notes
     **/
    public Notes selectById(Integer id);

    /**
     * @Author haien
     * @Description 查询本人笔记
     * @Date 2019/7/7
     * @Param [author]
     * @return java.util.List<Notes>
     **/
    public List<Notes> selectByAuthor(String author);

    /**
     * @Author haien
     * @Description 查询同标题笔记
     * @Date 2019/7/9
     * @Param [title]
     * @return com.ruoyi.project.llc.notes.domain.Notes
     **/
    public Notes selectByTitle(String title);

    /**
     * @Author haien
     * @Description 查询全部笔记
     * @Date 2019/7/7
     * @Param []
     * @return java.util.List<Notes>
     **/
    public List<Notes> seleteAllNotes();

    /**
     * @Author haien
     * @Description 新增笔记
     * @Date 2019/7/7
     * @Param [notes]
     * @return int
     **/
    public int insertNotes(Notes notes);

    /**
     * @Author haien
     * @Description 批量删除笔记
     * @Date 2019/7/7
     * @Param [ids]
     * @return int
     **/
    public int deleteNotesByIds(String[] ids);

    /**
     * @Author haien
     * @Description 更新笔记
     * @Date 2019/7/8
     * @Param [notes]
     * @return int
     **/
    public int updateNotes(Notes notes);
}
