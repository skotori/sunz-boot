package com.skotori.sunzboot.module.sys.model;

import java.util.Date;
import java.util.List;

/**
 * 角色实体类
 * @author skotori
 * @date 2019/11/06 20:39
 */
public class SysRole {

    //主键id
    private Integer id;
    //父角色id
    private Integer pid;
    //名称
    private String name;
    //排序号
    private Integer num;
    //部门id
    private Integer deptId;
    //状态(1：启用  2：禁用  3：删除）
    private Integer status;
    //创建时间
    private Date createTime;
    //创建人
    private Integer createUserId;
    //更新时间
    private Date updateTime;
    //更新人
    private Integer updateUserId;
    //管理员列表
    private List<SysUser> userList;
    //权限列表
    private List<SysPermission> permissionList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public List<SysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", deptId=" + deptId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", userList=" + userList +
                ", permissionList=" + permissionList +
                '}';
    }
}
