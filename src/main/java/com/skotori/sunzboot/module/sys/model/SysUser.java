package com.skotori.sunzboot.module.sys.model;

import java.util.Date;
import java.util.List;

/**
 * 管理员实体类
 * @author skotori
 * @date 2019/11/06 20:38
 */
public class SysUser {

    //主键id
    private Integer id;
    //账号
    private String account;
    //密码
    private String password;
    //md5密码盐
    private String salt;
    //名称
    private String name;
    //头像
    private String avatar;
    //性别（1：男 2：女）
    private Integer sex;
    //生日
    private Date birthday;
    //邮箱
    private String email;
    //电话
    private String phone;
    //部门id
    private Integer deptId;
    //状态(1：启用  2：禁用  3：删除）
    private Integer status;
    //备注
    private String note;
    //创建时间
    private Date createTime;
    //创建人
    private Integer createUser;
    //更新时间
    private Date updateTime;
    //更新人
    private Integer updateUser;
    //角色列表
    private List<SysRole> roleList;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptId=" + deptId +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", updateTime=" + updateTime +
                ", updateUser=" + updateUser +
                ", roleList=" + roleList +
                '}';
    }

    /**
     * 密码盐. 重新对盐重新进行了定义，账号+salt，这样就不容易被破解，可以采用多种方式定义加盐
     * @return
     */
    public String getCredentialsSalt(){
        return this.account+this.salt;
    }
}
