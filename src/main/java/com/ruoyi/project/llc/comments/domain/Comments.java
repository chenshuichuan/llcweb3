package com.ruoyi.project.llc.comments.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;

import java.util.Date;

/**
 * 访客留言表 llc_comments
 *
 * @author ricardo
 * @date 2019-03-09
 */
@Entity
@Table(name = "llc_comments" )
public class Comments extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
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
     * 留言内容
     */
    @Column(name = "content" )
    @Excel(name = "留言内容")
    private String content;
    /**
     * 联系方式
     */
    @Column(name = "contact" )
    @Excel(name = "联系方式")
    private String contact;
    /**
     * 留言时间
     */
    @Column(name = "create_time" )
    @Excel(name = "留言时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 管理员是否已经查看过
     */
    @Column(name = "is_view" )
    @Excel(name = "否已查看", readConverterExp = "0=已查看,1=未查看")
    private Integer isView;
    /**
     * ip地址
     */
    @Column(name = "ip_address" )
    @Excel(name = "ip地址")
    private String ipAddress;

    public Comments() {this.createTime = new Date();

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

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public Date getCreateTime() {
        return createTime;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }

    public Integer getIsView() {
        return isView;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("name" , getName())
                .append("content" , getContent())
                .append("contact" , getContact())
                .append("createTime" , getCreateTime())
                .append("isView" , getIsView())
                .append("ipAddress" , getIpAddress())
                .toString();
    }
}
