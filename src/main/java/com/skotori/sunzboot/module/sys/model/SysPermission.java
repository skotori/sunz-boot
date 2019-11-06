package com.skotori.sunzboot.module.sys.model;

import java.util.Date;
import java.util.List;

/**
 * 权限实体类
 * @author skotori
 * @date 2019/11/06 20:39
 */
public class SysPermission {

    //主键id
    private Integer id;
    //父权限id
    private Integer pid;
    //父权限id列表
    private String pids;
    //权限编码
    private String code;
    //名称
    private String name;
    //url地址
    private String url;
    //是否是菜单（1：是  0：不是）
    private Integer isMenu;
    //菜单是否默认打开（1：打开  0：不打开）
    private Integer isOpen;
    //菜单图标
    private String icon;
    //菜单排序号
    private Integer num;
    //菜单层级
    private Integer level;
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
    //角色列表
    private List<SysRole> roleList;

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

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", isMenu=" + isMenu +
                ", isOpen=" + isOpen +
                ", icon='" + icon + '\'' +
                ", num=" + num +
                ", level=" + level +
                ", status=" + status +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", updateTime=" + updateTime +
                ", updateUserId=" + updateUserId +
                ", roleList=" + roleList +
                '}';
    }
}
