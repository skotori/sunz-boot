package com.skotori.sunzboot.common.shiro;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 自定义ShiroUser对象，可以携带更多信息
 * @author skotori
 * @date 2019-11-15 10:58
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键ID
    private Integer id;
    // 账号
    private String account;
    // 名称
    private String name;
    // 头像
    private String icon;
    // 性别（1：男 2：女）
    private Integer sex;
    // 生日
    private Date birthday;
    // 邮箱
    private String email;
    // 电话
    private String tell;
    // 部门id
    private Integer deptId;

    // 部门名称
    private String deptName;
    // 角色编码集
    private List<String> roleCodes;
    // 权限编码集
    private List<String> permissionCodes;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(List<String> roleCodes) {
        this.roleCodes = roleCodes;
    }

    public List<String> getPermissionCodes() {
        return permissionCodes;
    }

    public void setPermissionCodes(List<String> permissionCodes) {
        this.permissionCodes = permissionCodes;
    }

    @Override
    public String toString() {
        return "ShiroUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", tell='" + tell + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", roleCodes=" + roleCodes +
                ", permissionCodes=" + permissionCodes +
                '}';
    }
}
