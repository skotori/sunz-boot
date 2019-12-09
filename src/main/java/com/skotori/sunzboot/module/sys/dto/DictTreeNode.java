package com.skotori.sunzboot.module.sys.dto;

import com.skotori.sunzboot.util.TreeNode;

import java.util.Date;

public class DictTreeNode extends TreeNode {

    // 排序号
    private Integer num;
    // 名称
    private String name;
    // 值
    private String code;
    // 状态(1：启用  2：禁用）
    private Integer status;
    // 备注
    private String note;
    // 创建时间
    private Date createTime;
    // 创建人
    private String createUser;
    // 更新时间
    private Date updateTime;
    // 更新人
    private String updateUser;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "DictTreeNode{" +
                "id=" + id +
                ", pid=" + pid +
                ", label='" + label + '\'' +
                ", children=" + children +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", updateTime=" + updateTime +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
