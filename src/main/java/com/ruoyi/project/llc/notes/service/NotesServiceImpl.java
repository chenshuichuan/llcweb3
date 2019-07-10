package com.ruoyi.project.llc.notes.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.llc.notes.domain.Notes;
import com.ruoyi.project.llc.notes.mapper.NotesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Service("notesService")
public class NotesServiceImpl implements NotesService {
    @Resource
    private NotesMapper notesMapper;

    @Override
    public Notes selectById(Integer id) {
        return notesMapper.selectById(id);
    }

    @Override
    public List<Notes> selectByAuthor(String author) {
        return notesMapper.selectByAuthor(author);
    }

    @Override
    public Notes selectByTitle(String title) {
        return notesMapper.selectByTitle(title);
    }

    @Override
    public List<Notes> seleteAllNotes() {
        return notesMapper.seleteAllNotes();
    }

    @Override
    public int insertNotes(Notes notes) {
        notes.setAuthor(ShiroUtils.getLoginName());
        return notesMapper.insertNotes(notes);
    }

    @Override
    public int updateNotes(Notes notes) {
        int result=0;

        //判断笔记是否存在
        Notes oldNotes=notesMapper.selectById(notes.getId());
        if(null!=oldNotes){
            result=notesMapper.updateNotes(notes);
            File file=new File(oldNotes.getUrl());
            file.delete();
        }

        return result;
    }

    @Override
    public int deleteNotesByIds(String ids) {
        if(ids.length()>0){
            String[] id = ids.split(",");
            Notes notes;
            File file;

            //删除服务器文件
            for (int i = 0; i < id.length; i++) {
                notes=notesMapper.selectById(Integer.valueOf(id[i]));
                if(null!=notes){
                    file=new File(notes.getUrl());
                    file.delete();
                }
            }

            //删除数据库记录
            return notesMapper.deleteNotesByIds(id);
        }

        return 0;
    }

    @Override
    public String checkNotesTitleUnqiue(Notes srcNote) {
        Notes notes = notesMapper.selectByTitle(srcNote.getTitle());
        if (notes != null && !notes.getId().equals(srcNote.getId())) {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }
}
