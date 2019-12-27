package com.skotori.sunzboot.common.tree.treeNode;

import java.util.Date;
import java.util.List;

/**
 * 菜单树形节点类
 * @author skotori
 * @date 2019-12-19 18:01
 */
public class MenuTreeNode {

    // 节点id
    private Integer id;
    // 父节点id
    private Integer pid;
    // 父节点id列表
    private String pids;
    // 节点名称
    private String name;
    // 路径
    private String path;
    // 组件
    private String component;
    // 图标
    private String icon;
    // 排序号
    private Integer num;
    // 子节点集合
    private List<MenuTreeNode> children;
    // 编码
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
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

    public List<MenuTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeNode> children) {
        this.children = children;
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
        return "MenuTreeNode{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", icon='" + icon + '\'' +
                ", num=" + num +
                ", children=" + children +
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
