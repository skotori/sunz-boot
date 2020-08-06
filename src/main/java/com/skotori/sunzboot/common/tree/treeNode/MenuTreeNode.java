package com.skotori.sunzboot.common.tree.treeNode;

/**
 * 菜单树形节点类
 * @author skotori
 * @date 2019-12-19 18:01
 */
public class MenuTreeNode extends TreeNode {

    // 图标
    private String icon;
    // 名称
    private String name;
    // 编码
    private String code;
    // 路径
    private String path;
    // 组件
    private String component;
    // 排序号
    private Integer sortNum;
    // 禁用状态(0：未禁用 1：已禁用)
    private Integer disabledState;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getDisabledState() {
        return disabledState;
    }

    public void setDisabledState(Integer disabledState) {
        this.disabledState = disabledState;
    }

}
