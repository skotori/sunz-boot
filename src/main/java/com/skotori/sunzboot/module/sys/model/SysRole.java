package com.skotori.sunzboot.module.sys.model;

import java.util.Date;
import java.util.List;

/**
 * 角色实体类
 * @author skotori
 * @date 2019/11/06 20:39
 */
public class SysRole {

    // 主键id
    private Integer id;
    // 编码
    private String code;
    // 名称
    private String name;
    // 排序号
    private Integer num;
    // 部门id
    private Integer deptId;
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
    // 管理员列表
    private List<SysUser> users;
    // 权限列表
    private List<SysPower> powers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public List<SysPower> getPowers() {
        return powers;
    }

    public void setPowers(List<SysPower> powers) {
        this.powers = powers;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", deptId=" + deptId +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", updateTime=" + updateTime +
                ", updateUser=" + updateUser +
                ", users=" + users +
                ", powers=" + powers +
                '}';
    }
}
