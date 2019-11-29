package com.skotori.sunzboot.module.sys.model;

import java.util.Date;

/**
 * 登录日志实体类
 * @author skotori
 * @date 2019-11-27 17:35
 */
public class SysLoginLog {

    // 主键id
    private Integer id;
    // 账号
    private String account;
    // 登录日志类型(1：成功日志  2：失败日志）
    private Integer type;
    // 登录时间
    private Date time;
    // 登录ip
    private String ip;
    // 登录信息
    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String userId) {
        this.account = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SysLoginLog{" +
                "id=" + id +
                ", account=" + account +
                ", type=" + type +
                ", time=" + time +
                ", ip='" + ip + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
