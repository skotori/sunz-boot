package com.skotori.sunzboot.util;

import java.util.List;

/**
 * 树形节点实体类
 * @author skotori
 * @date 2019-12-05 16:13
 */
public class TreeNode {

    // 节点id
    private Integer id;
    // 父节点id
    private Integer pid;
    // 节点名称
    private String label;
    // 子节点集合
    private List<TreeNode> children;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", pid=" + pid +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
