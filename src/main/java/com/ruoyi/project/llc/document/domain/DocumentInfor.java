package com.ruoyi.project.llc.document.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;

/**
 * 文档管理表 llc_document
 *
 * @author ricardo
 * @date 2019-03-09
 */

public class DocumentInfor {
    private static final long serialVersionUID = 1L;

    /**
     * 文档id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者名称
     */
    private String author;
    /**
     * 内容
     */
    private String content;
    /**
     * 文档注释
     */

    private String infor;
    /**
     * 组别
     */

    private String model;
    /**
     * 创建时间
     */

    private Date createTime;
    /**
     * 更新时间
     */

    private Date updateTime;

    public DocumentInfor() {

    }
    public DocumentInfor(Document document) {
        this.id = document.getId();
        this.title = document.getTitle();
        this.author = document.getAuthor();
        //this.content = content;
        this.infor = document.getInfor();
        this.model = document.getModel();
        this.createTime = document.getCreateTime();
        this.updateTime = document.getUpdateTime();
    }
    public DocumentInfor(Integer id, String title, String author, String content,
                         String infor, String model, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.infor = infor;
        this.model = model;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public String getInfor() {
        return infor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("title" , getTitle())
                .append("author" , getAuthor())
                .append("content" , getContent())
                .append("infor" , getInfor())
                .append("model" , getModel())
                .append("createTime" , getCreateTime())
                .append("updateTime" , getUpdateTime())
                .toString();
    }
}
