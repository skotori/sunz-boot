package com.skotori.sunzboot.common.shiro;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @author skotori
 * @date 2019-11-15 10:58
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键ID
    private Integer id;
    // 账号
    private String account;
    // 密码
    private String password;
    // md5密码盐
    private String credentialsSalt;
    // 名称
    private String name;
    // 状态(1：启用  2：禁用  3：删除）
    private Integer status;
    // 部门id
    private Integer deptId;
    // 角色id集
    private List<Integer> roleIds;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getCredentialsSalt() {
        return credentialsSalt;
    }

    public void setCredentialsSalt(String credentialsSalt) {
        this.credentialsSalt = credentialsSalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "ShiroUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", credentialsSalt='" + credentialsSalt + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", deptId=" + deptId +
                ", roleIds=" + roleIds +
                '}';
    }
}
