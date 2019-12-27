package com.skotori.sunzboot.common.tree.treeNode;

import com.skotori.sunzboot.module.sys.model.SysRole;

import java.util.Date;
import java.util.List;

/**
 * 权限树形节点类
 * @author skotori
 * @date 2019-12-19 19:04
 */
public class PowerTreeNode {

    // 节点id
    private Integer id;
    // 父节点id
    private Integer pid;
    // 父节点id列表
    private String pids;
    // 节点名称
    public String label;
    // 节点名称
    private String name;
    // 排序号
    private Integer num;
    // 子节点集合
    private List<PowerTreeNode> children;
    // 编码
    private String code;
    // 路径
    private String path;
    // 图标
    private String icon;
    // 类型(1：菜单 2：页面元素 3：文件 4：功能操作)
    private Integer type;
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
    // 角色列表
    private List<SysRole> roles;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public List<PowerTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<PowerTreeNode> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "PowerTreeNode{" +
                "id=" + id +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", children=" + children +
                ", code='" + code + '\'' +
                ", path='" + path + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", updateTime=" + updateTime +
                ", updateUser='" + updateUser + '\'' +
                ", roles=" + roles +
                '}';
    }
}
