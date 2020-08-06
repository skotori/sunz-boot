package com.skotori.sunzboot.module.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 系统用户实体类
 * @author skotori
 * @date 2019/11/06 20:38
 */
public class SysUser {

    // 主键id
    private Integer id;
    // 账号
    private String account;
    // 密码
    private String password;
    // md5加密盐
    private String salt;
    // 名称
    private String name;
    // 头像
    private String icon;
    // 性别（0：女 1：男）
    private Integer sex;
    // 生日
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    // 邮箱
    private String email;
    // 电话
    private String tell;
    // 部门id
    private Integer deptId;
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

    // 角色列表
    private List<SysRole> roles;
    // 部门名称
    private String deptName;
    // 关键词搜索
    private String keyword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", tell='" + tell + '\'' +
                ", deptId=" + deptId +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", updateTime=" + updateTime +
                ", updateUser='" + updateUser + '\'' +
                ", deleteTime=" + deleteTime +
                ", deleteUser='" + deleteUser + '\'' +
                ", deletedState=" + deletedState +
                ", disabledState=" + disabledState +
                ", roles=" + roles +
                ", deptName='" + deptName + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    /**
     * 加密盐：重新定义盐(account + salt)
     * @return
     */
    public String getCredentialsSalt(){
        if (this.salt != null && !"".equals(this.salt)) {
            return this.account + this.salt;
        } else {
            return null;
        }
    }
}
