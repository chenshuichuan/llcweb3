package com.ruoyi.project.llc.images.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 图片上传表 llc_images
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_images" )
public class Images extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    @Id
    @GeneratedValue
    @Column(name = "id" )
    private Integer id;
    /**
     * 完整url
     */
    @Column(name = "url" )
    private String url;
    /**
     * 状态
     */
    @Column(name = "status" )
    private String status;
    /**
     * 文件名称
     */
    @Column(name = "file_name" )
    private String fileName;
    /**
     * 原始名称
     */
    @Column(name = "original_name" )
    private String originalName;
    /**
     * 注释
     */
    @Column(name = "remark" )
    private String remark;
    /**
     * 文字内容
     */
    @Column(name = "content" )
    private String content;
    /**
     * 后缀
     */
    @Column(name = "suffix" )
    private String suffix;
    /**
     * 文件类型
     */
    @Column(name = "type" )
    private Integer type;
    /**
     * 创建者
     */
    @Column(name = "author" )
    private String author;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
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
                .append("url" , getUrl())
                .append("status" , getStatus())
                .append("fileName" , getFileName())
                .append("originalName" , getOriginalName())
                .append("remark" , getRemark())
                .append("content" , getContent())
                .append("suffix" , getSuffix())
                .append("type" , getType())
                .append("author" , getAuthor())
                .append("createTime" , getCreateTime())
                .append("updateTime" , getUpdateTime())
                .toString();
    }
}
