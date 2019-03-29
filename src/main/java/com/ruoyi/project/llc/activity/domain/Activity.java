package com.ruoyi.project.llc.activity.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 活动管理表 llc_activity
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_activity" )
public class Activity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    @Excel(name = "id")
    private Integer id;
    /**
     * 活动名称
     */
    @Column(name = "name" )
    @Excel(name = "活动名称")
    private String name;
    /**
     * 活动发布者
     */
    @Column(name = "author" )
    @Excel(name = "活动名称")
    private String author;
    /**
     * 活动参与者
     */
    @Column(name = "people_list" )
    @Excel(name = "活动参与者")
    private String peopleList;
    /**
     * 开始时间
     */
    @Column(name = "start_date" )
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    /**
     * 结束时间
     */
    @Column(name = "end_date" )
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    /**
     * 活动简介
     */
    @Column(name = "introduction" )
    @Excel(name = "活动简介")
    private Integer introduction;
    /**
     * 组别
     */
    @Column(name = "model" )
    @Excel(name = "组别")
    private String model;
    /**
     * 活动类型,通知、会议、招聘、活动等
     */
    @Column(name = "activity_type" )
    @Excel(name = "活动类型")
    private String activityType;
    /**
     * 是否发布出去
     */
    @Column(name = "is_publish" )
    @Excel(name = "是否发布", readConverterExp = "0=不发布,1=发布")
    private Integer isPublish;

    public Activity() {
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPeopleList(String peopleList) {
        this.peopleList = peopleList;
    }

    public String getPeopleList() {
        return peopleList;
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

    public void setIntroduction(Integer introduction) {
        this.introduction = introduction;
    }

    public Integer getIntroduction() {
        return introduction;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("name" , getName())
                .append("author" , getAuthor())
                .append("peopleList" , getPeopleList())
                .append("startDate" , getStartDate())
                .append("endDate" , getEndDate())
                .append("introduction" , getIntroduction())
                .append("model" , getModel())
                .append("activityType" , getActivityType())
                .append("isPublish" , getIsPublish())
                .toString();
    }
}
