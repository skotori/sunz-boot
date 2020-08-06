package com.skotori.sunzboot.common.tree.treeNode;

import java.util.List;

/**
 * 树型节点基础类
 * @author skotori
 * @date 2020-08-04 15:30
 */
public class TreeNode {

    // 主键id
    private Integer id;
    // 父级id
    private Integer parentId;

    // 节点名称
    public String label;
    // 子节点集合
    private List<TreeNode> children;
    // 是否禁用
    private boolean disabled;
    // 是否为叶子节点
    private boolean isLeaf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

}
