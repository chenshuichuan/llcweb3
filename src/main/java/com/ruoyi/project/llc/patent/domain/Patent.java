package com.ruoyi.project.llc.patent.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 专利成果表 llc_patent
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_patent" )
public class Patent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    @Excel(name = "id")
    private Integer id;
    /**
     * 专利标题
     */
    @Column(name = "title" )
    @Excel(name = "专利标题")
    private String title;
    /**
     * 申请日
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "appli_date" )
    @Excel(name = "申请日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appliDate;
    /**
     * 专利介绍
     */
    @Column(name = "introduction" )
    @Excel(name = "专利介绍")
    private Integer introduction;
    /**
     * 作者姓名列表
     */
    @Column(name = "author_list" )
    @Excel(name = "作者")
    private String authorList;
    /**
     * 原文链接
     */
    @Column(name = "original_link" )
    @Excel(name = "原文链接")
    private String originalLink;
    /**
     * 关联的文件id
     */
    @Column(name = "source_file" )
    @Excel(name = "关联的文件")
    private Integer sourceFile;
    /**
     * 专利申请号
     */
    @Column(name = "appli_num" )
    @Excel(name = "申请号")
    private String appliNum;
    /**
     * 申请人（一般为广东工业大学）
     */
    @Column(name = "appli_people" )
    @Excel(name = "申请人")
    private String appliPeople;
    /**
     * 申请日期
     */
    @Column(name = "application_date" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationDate;
    /**
     * 专利公开号
     */
    @Column(name = "public_num" )
    @Excel(name = "专利公开号")
    private String publicNum;
    /**
     * 公开日
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "public_date" )
    @Excel(name = "公开日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publicDate;
    /**
     * 授权日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "authorization_date" )
    @Excel(name = "授权日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date authorizationDate;
    /**
     * 代理机构
     */
    @Column(name = "agency" )
    @Excel(name = "代理机构")
    private String agency;
    /**
     * 专利状态
     */
    @Column(name = "state" )
    @Excel(name = "专利状态")
    private String state;
    /**
     * 组别
     */
    @Column(name = "model" )
    @Excel(name = "组别")
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
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTime;

    public Patent() {
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

    public void setAppliDate(Date appliDate) {
        this.appliDate = appliDate;
    }

    public Date getAppliDate() {
        return appliDate;
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

    public void setAppliNum(String appliNum) {
        this.appliNum = appliNum;
    }

    public String getAppliNum() {
        return appliNum;
    }

    public void setAppliPeople(String appliPeople) {
        this.appliPeople = appliPeople;
    }

    public String getAppliPeople() {
        return appliPeople;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setPublicNum(String publicNum) {
        this.publicNum = publicNum;
    }

    public String getPublicNum() {
        return publicNum;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setAuthorizationDate(Date authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public Date getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAgency() {
        return agency;
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
                .append("appliDate" , getAppliDate())
                .append("introduction" , getIntroduction())
                .append("authorList" , getAuthorList())
                .append("originalLink" , getOriginalLink())
                .append("sourceFile" , getSourceFile())
                .append("appliNum" , getAppliNum())
                .append("appliPeople" , getAppliPeople())
                .append("applicationDate" , getApplicationDate())
                .append("publicNum" , getPublicNum())
                .append("publicDate" , getPublicDate())
                .append("authorizationDate" , getAuthorizationDate())
                .append("agency" , getAgency())
                .append("state" , getState())
                .append("model" , getModel())
                .append("isPublish" , getIsPublish())
                .append("updateTime" , getUpdateTime())
                .toString();
    }
}
