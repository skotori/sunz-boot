package com.skotori.sunzboot.common.tree.treeNode;

import java.util.Date;

/**
 * 部门树心节点类
 * @author skotori
 * @date 2019-12-19 19:27
 */
public class DeptTreeNode extends TreeNode {

    // 父父级id数组字符串(以","为间隔)
    private String parentIds;
    // 名称
    private String name;
    // 排序号
    private Integer sortNum;
    // 备注
    private String remark;
    // 创建时间
    private Date createTime;
    // 创建用户
    private String createUser;
    // 更新时间
    private Date updateTime;
    // 更新用户
    private String updateUser;
    // 删除时间
    private Date deleteTime;
    // 删除用户
    private String deleteUser;
    // 删除状态(0：未删除 1：已删除)
    private Integer deletedState;
    // 禁用状态(0：未禁用 1：已禁用)
    private Integer disabledState;

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }

    public Integer getDeletedState() {
        return deletedState;
    }

    public void setDeletedState(Integer deletedState) {
        this.deletedState = deletedState;
    }

    public Integer getDisabledState() {
        return disabledState;
    }

    public void setDisabledState(Integer disabledState) {
        this.disabledState = disabledState;
    }

}
