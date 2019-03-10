package com.ruoyi.project.llc.document.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 文档管理表 llc_document
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_document" )
public class Document extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 文档id
     */
    @Id
    @GeneratedValue
    @Column(name = "id" )
    private Integer id;
    /**
     * 标题
     */
    @Column(name = "title" )
    private String title;
    /**
     * 作者名称
     */
    @Column(name = "author" )
    private String author;
    /**
     * 内容
     */
    @Column(name = "content" )
    private String content;
    /**
     * 文档注释
     */
    @Column(name = "infor" )
    private String infor;
    /**
     * 组别
     */
    @Column(name = "model" )
    private String model;
    /**
     * 创建时间
     */
    @Column(name = "create_time" )
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time" )
    private Date updateTime;

    public Document() {
        this.updateTime = new Date();
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
    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public Date getCreateTime() {
        return createTime;
    }
    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @Override
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
