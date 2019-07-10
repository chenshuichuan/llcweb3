package com.ruoyi.project.llc.notes.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author haien
 * @Description 阅读笔记类
 * @Date 2019/7/7
 **/
@Entity
@Table(name = "llc_notes")
public class Notes extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    /** 笔记标题 */
    private String title;

    @Column
    /** 下载路径 */
    private String url;

    @Column
    /** 是否可用(0可用，1不可用) */
    private String status="0";

    @Column
    /** 作者 */
    private String author;

    /** 创建时间 */
    @Column(name = "create_time" )
    private Date createTime;

    /** 更新时间 */
    @Column(name = "update_time" )
    private Date updateTime;

    /**修改标识 0 新增 1 修改**/
    @Transient
    private int updateFlag;

    public Notes() {
        this.updateTime = new Date();
    }

    public Notes(Integer id, String title, String url, String status,
                 String author, Date createTime, Date updateTime, int updateFlag) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.status = status;
        this.author = author;
        this.updateTime = updateTime;
        this.createTime=createTime;
        this.updateFlag=updateFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(int updateFlag) {
        this.updateFlag = updateFlag;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
