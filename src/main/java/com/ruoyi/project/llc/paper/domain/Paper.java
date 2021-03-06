package com.ruoyi.project.llc.paper.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 论文成果表 llc_paper
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_paper" )
public class Paper extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    @Excel(name = "id")
    private Integer id;
    /**
     * 题目
     */
    @Column(name = "title" )
    @Excel(name = "题目")
    private String title;
    /**
     * 发表日期
     */
    @Column(name = "public_date" )
    @Excel(name = "发表日期", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date publicDate;
    /**
     * 论文介绍
     */
    @Column(name = "introduction" )
    @Excel(name = "论文介绍")
    private Integer introduction;
    /**
     * 作者列表
     */
    @Column(name = "author_list" )
    @Excel(name = "作者列表")
    private String authorList;
    /**
     * 原文链接
     */
    @Column(name = "original_link" )
    @Excel(name = "原文链接")
    private String originalLink;
    /**
     * 论文文件
     */
    @Column(name = "source_file" )
    @Excel(name = "论文文件")
    private Integer sourceFile;
    /**
     * 所属项目id
     */
    @Column(name = "belong_project" )
    @Excel(name = "所属项目")
    private String belongProject;
    /**
     * 发表期刊
     */
    @Column(name = "periodical" )
    @Excel(name = "发表期刊")
    private String periodical;
    /**
     * 期刊类别
     */
    @Column(name = "periodical_type" )
    @Excel(name = "期刊类别")
    private String periodicalType;
    /**
     * 当前状态
     */
    @Column(name = "state" )
    @Excel(name = "当前状态")
    private String state;
    /**
     * 项目组
     */
    @Column(name = "model" )
    @Excel(name = "项目组")
    private String model;
    /**
     * 是否发布
     */
    @Column(name = "is_publish" )
    @Excel(name = "是否发布", readConverterExp = "0=不发布,1=发布")
    private Integer isPublish;
    /**
     * 更新时间
     */
    @Column(name = "update_time" )
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Paper() {
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

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setIntroduction(Integer introduction) {
        this.introduction = introduction;
    }

    public Integer getIntroduction() {
        return introduction;
    }

    public void setAuthorList(String authorList) {
        this.authorList = authorList;
    }

    public String getAuthorList() {
        return authorList;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setSourceFile(Integer sourceFile) {
        this.sourceFile = sourceFile;
    }

    public Integer getSourceFile() {
        return sourceFile;
    }

    public void setBelongProject(String belongProject) {
        this.belongProject = belongProject;
    }

    public String getBelongProject() {
        return belongProject;
    }

    public void setPeriodical(String periodical) {
        this.periodical = periodical;
    }

    public String getPeriodical() {
        return periodical;
    }

    public void setPeriodicalType(String periodicalType) {
        this.periodicalType = periodicalType;
    }

    public String getPeriodicalType() {
        return periodicalType;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getIsPublish() {
        return isPublish;
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
                .append("publicDate" , getPublicDate())
                .append("introduction" , getIntroduction())
                .append("authorList" , getAuthorList())
                .append("originalLink" , getOriginalLink())
                .append("sourceFile" , getSourceFile())
                .append("belongProject" , getBelongProject())
                .append("periodical" , getPeriodical())
                .append("periodicalType" , getPeriodicalType())
                .append("state" , getState())
                .append("model" , getModel())
                .append("isPublish" , getIsPublish())
                .append("updateTime" , getUpdateTime())
                .toString();
    }
}
