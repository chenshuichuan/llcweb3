package com.ruoyi.project.llc.people.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 人员管理表 llc_people
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_people" )
public class People extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 人物id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    @Excel(name = "id")
    private Integer id;
    /**
     * 姓名
     */
    @Column(name = "name" )
    @Excel(name = "姓名")
    private String name;
    /**
     * 手机号
     */
    @Column(name = "phone" )
    @Excel(name = "手机号码")
    private String phone;
    /**
     * y邮箱
     */
    @Column(name = "email" )
    @Excel(name = "邮箱")
    private String email;
    /**
     * 人物头像图片路径，关联image表
     */
    @Column(name = "portrait" )
    @Excel(name = "人物头像")
    private Integer portrait;
    /**
     * 职位，教授、副教授、讲师、博士后、博士、硕士，本科生
     */
    @Column(name = "position" )
    @Excel(name = "职位")
    private String position;
    /**
     * 关联document表
     */
    @Column(name = "introduction" )
    @Excel(name = "关联document")
    private Integer introduction;
    /**
     * 本科生、硕士生、博士生是届数；讲师，教授，等是加入年份
     */
    @Column(name = "grade" )
    @Excel(name = "年级")
    private Integer grade;
    /**
     * 研究方向
     */
    @Column(name = "research_field" )
    @Excel(name = "研究方向")
    private String researchField;
    /**
     * 学术头衔
     */
    @Column(name = "academic_title" )
    @Excel(name = "学术头衔")
    private String academicTitle;
    /**
     * 行政职务
     */
    @Column(name = "admin_position" )
    @Excel(name = "行政职务")
    private String adminPosition;
    /**
     * 最高学历
     */
    @Column(name = "highest_degree" )
    @Excel(name = "最高学历")
    private String highestDegree;
    /**
     * 性别
     */
    @Column(name = "sex" )
    @Excel(name = "性别")
    private String sex;
    /**
     * 更新时间
     */
    @Column(name = "update_time" )
    @Excel(name = "更新时间")
    private Date updateTime;

    public People() {
        this.updateTime = new Date();
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPortrait(Integer portrait) {
        this.portrait = portrait;
    }

    public Integer getPortrait() {
        return portrait;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setIntroduction(Integer introduction) {
        this.introduction = introduction;
    }

    public Integer getIntroduction() {
        return introduction;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public String getResearchField() {
        return researchField;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAdminPosition(String adminPosition) {
        this.adminPosition = adminPosition;
    }

    public String getAdminPosition() {
        return adminPosition;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
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
                .append("phone" , getPhone())
                .append("email" , getEmail())
                .append("portrait" , getPortrait())
                .append("position" , getPosition())
                .append("introduction" , getIntroduction())
                .append("grade" , getGrade())
                .append("researchField" , getResearchField())
                .append("academicTitle" , getAcademicTitle())
                .append("adminPosition" , getAdminPosition())
                .append("highestDegree" , getHighestDegree())
                .append("sex" , getSex())
                .append("updateTime" , getUpdateTime())
                .toString();
    }
}
