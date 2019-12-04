package com.skotori.sunzboot.module.sys.model;

import java.util.Date;

/**
 * 通知实体类
 * @author skotori
 * @date 2019-12-04 08:50
 */
public class SysNotice {

    // 主键id
    private Integer id;
    // 标题
    private String title;
    // 内容
    private String content;
    // 创建时间
    private Date createTime;
    // 创建人
    private String createUser;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "SysNotice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
