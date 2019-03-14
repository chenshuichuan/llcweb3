package com.ruoyi.project.llc.software.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 软著成果表 llc_software
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_software" )
public class Software extends BaseEntity {
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
     * 名称
     */
    @Column(name = "title" )
    @Excel(name = "名称")
    private String title;
    /**
     * 申请日
     */
    @Column(name = "appli_date" )
    @Excel(name = "申请日")
    private Date appliDate;
    /**
     * 摘要
     */
    @Column(name = "introduction" )
    @Excel(name = "是否发布")
    private String introduction;
    /**
     * 发明人列表
     */
    @Column(name = "author_list" )
    @Excel(name = "发明人列表")
    private String authorList;
    /**
     * 关联的文件id
     */
    @Column(name = "source_file" )
    @Excel(name = "关联的文件")
    private Integer sourceFile;
    /**
     * 所属项目
     */
    @Column(name = "belong_project" )
    @Excel(name = "所属项目")
    private String belongProject;
    /**
     * 公开号
     */
    @Column(name = "public_num" )
    @Excel(name = "公开号")
    private String publicNum;
    /**
     * 公开日
     */
    @Column(name = "public_date" )
    @Excel(name = "公开日")
    private Date publicDate;
    /**
     * 状态
     */
    @Column(name = "status" )
    @Excel(name = "状态")
    private String status;
    /**
     * 权利取得方式
     */
    @Column(name = "public_method" )
    @Excel(name = "权利取得方式")
    private String publicMethod;
    /**
     * 权利范围
     */
    @Column(name = "right_range" )
    @Excel(name = "权利范围")
    private String rightRange;
    /**
     * 是否发布
     */
    @Column(name = "is_publish" )
    @Excel(name = "是否发布")
    private Integer isPublish;
    /**
     * 更新时间
     */
    @Column(name = "update_time" )
    @Excel(name = "更新时间")
    private Date updateTime;

    public Software() {
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

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setAuthorList(String authorList) {
        this.authorList = authorList;
    }

    public String getAuthorList() {
        return authorList;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPublicMethod(String publicMethod) {
        this.publicMethod = publicMethod;
    }

    public String getPublicMethod() {
        return publicMethod;
    }

    public void setRightRange(String rightRange) {
        this.rightRange = rightRange;
    }

    public String getRightRange() {
        return rightRange;
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
                .append("sourceFile" , getSourceFile())
                .append("belongProject" , getBelongProject())
                .append("publicNum" , getPublicNum())
                .append("publicDate" , getPublicDate())
                .append("status" , getStatus())
                .append("publicMethod" , getPublicMethod())
                .append("rightRange" , getRightRange())
                .append("isPublish" , getIsPublish())
                .append("updateTime" , getUpdateTime())
                .toString();
    }
}
