package com.skotori.sunzboot.common.tree.treeNode;

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
    // 节点名称
    private String name;
    // 路径
    private String path;
    // 组件
    private String component;
    // 图标
    private String icon;
    // 子节点集合
    private List<MenuTreeNode> children;
    // 编码
    private String code;
    // 状态(1：启用  2：禁用）
    private Integer status;

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

    @Override
    public String toString() {
        return "MenuTreeNode{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", icon='" + icon + '\'' +
                ", children=" + children +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
