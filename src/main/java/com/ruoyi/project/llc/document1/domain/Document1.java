package com.ruoyi.project.llc.document1.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 原文档表 llc_document1
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_document1" )
public class Document1 extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Integer id;
    /**
     * people表的作者名称
     */
    @Column(name = "author" )
    private String author;
    /**
     * 内容
     */
    @Column(name = "content" )
    private String content;
    /**
     * 关于该文档的注释
     */
    @Column(name = "infor" )
    private String infor;
    /**
     * b标题
     */
    @Column(name = "title" )
    private String title;
    /**
     * 组别
     */
    @Column(name = "model" )
    private String model;
    /**
     * people表的作者id
     */
    @Column(name = "author_id" )
    private Integer authorId;
    /**  */
    @Column(name = "create_date" )
    private Date createDate;
    /**  */
    @Column(name = "modify_date" )
    private Date modifyDate;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("author" , getAuthor())
                .append("content" , getContent())
                .append("infor" , getInfor())
                .append("title" , getTitle())
                .append("model" , getModel())
                .append("authorId" , getAuthorId())
                .append("createDate" , getCreateDate())
                .append("modifyDate" , getModifyDate())
                .toString();
    }
}
