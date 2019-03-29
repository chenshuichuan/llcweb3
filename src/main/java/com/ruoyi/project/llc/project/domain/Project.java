package com.ruoyi.project.llc.project.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 项目管理表 llc_project
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_project" )
public class Project extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    @Excel(name = "id")
    private Integer id;
    /**
     * 项目名称
     */
    @Column(name = "name" )
    @Excel(name = "项目名称")
    private String name;
    /**
     * 项目编号
     */
    @Column(name = "require_num" )
    @Excel(name = "项目编号")
    private String requireNum;
    /**
     * 项目介绍
     */
    @Column(name = "introduction" )
    @Excel(name = "是否发布")
    private Integer introduction;
    /**
     * 介绍文件
     */
    @Column(name = "introduction_file" )
    @Excel(name = "介绍文件")
    private Integer introductionFile;
    /**
     * 项目状态
     */
    @Column(name = "status" )
    @Excel(name = "项目状态")
    private String status;
    /**
     * 研究领域
     */
    @Column(name = "research_field" )
    @Excel(name = "研究领域")
    private String researchField;
    /**
     * 项目经费
     */
    @Column(name = "money" )
    @Excel(name = "项目经费")
    private String money;
    /**
     * 开始时间
     */
    @Column(name = "start_date" )
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;
    /**
     * 结束时间
     */
    @Column(name = "end_date" )
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;
    /**
     * 项目负责人
     */
    @Column(name = "responsible_person" )
    @Excel(name = "项目负责人")
    private String responsiblePerson;
    /**
     * 项目类型
     */
    @Column(name = "project_type" )
    @Excel(name = "项目类型")
    private String projectType;
    /**
     * 项目人员
     */
    @Column(name = "members" )
    @Excel(name = "项目人员")
    private String members;
    /**
     * 项目描述
     */
    @Column(name = "project_des" )
    @Excel(name = "项目描述")
    private String projectDes;
    /**
     * 项目目标
     */
    @Column(name = "project_aim" )
    @Excel(name = "项目目标")
    private String projectAim;
    /**
     * 主办单位
     */
    @Column(name = "host_unit" )
    @Excel(name = "主办单位")
    private String hostUnit;
    /**
     * 协办单位
     */
    @Column(name = "co_unit" )
    @Excel(name = "协办单位")
    private String coUnit;
    /**
     * 承办单位
     */
    @Column(name = "undertake_unit" )
    @Excel(name = "承办单位")
    private String undertakeUnit;
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
    /**
     * 所属类别：用于门户分类
     */
    @Column(name = "team" )
    @Excel(name = "所属类别")
    private String team;

    public Project() {
        this.updateTime = new Date();
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRequireNum(String requireNum) {
        this.requireNum = requireNum;
    }

    public String getRequireNum() {
        return requireNum;
    }

    public void setIntroduction(Integer introduction) {
        this.introduction = introduction;
    }

    public Integer getIntroduction() {
        return introduction;
    }

    public void setIntroductionFile(Integer introductionFile) {
        this.introductionFile = introductionFile;
    }

    public Integer getIntroductionFile() {
        return introductionFile;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public String getResearchField() {
        return researchField;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getMembers() {
        return members;
    }

    public void setProjectDes(String projectDes) {
        this.projectDes = projectDes;
    }

    public String getProjectDes() {
        return projectDes;
    }

    public void setProjectAim(String projectAim) {
        this.projectAim = projectAim;
    }

    public String getProjectAim() {
        return projectAim;
    }

    public void setHostUnit(String hostUnit) {
        this.hostUnit = hostUnit;
    }

    public String getHostUnit() {
        return hostUnit;
    }

    public void setCoUnit(String coUnit) {
        this.coUnit = coUnit;
    }

    public String getCoUnit() {
        return coUnit;
    }

    public void setUndertakeUnit(String undertakeUnit) {
        this.undertakeUnit = undertakeUnit;
    }

    public String getUndertakeUnit() {
        return undertakeUnit;
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
                .append("name" , getName())
                .append("requireNum" , getRequireNum())
                .append("introduction" , getIntroduction())
                .append("introductionFile" , getIntroductionFile())
                .append("status" , getStatus())
                .append("researchField" , getResearchField())
                .append("money" , getMoney())
                .append("startDate" , getStartDate())
                .append("endDate" , getEndDate())
                .append("responsiblePerson" , getResponsiblePerson())
                .append("projectType" , getProjectType())
                .append("members" , getMembers())
                .append("projectDes" , getProjectDes())
                .append("projectAim" , getProjectAim())
                .append("hostUnit" , getHostUnit())
                .append("coUnit" , getCoUnit())
                .append("undertakeUnit" , getUndertakeUnit())
                .append("isPublish" , getIsPublish())
                .append("updateTime" , getUpdateTime())
                .append("team",getTeam())
                .toString();
    }
}
