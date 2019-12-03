package com.skotori.sunzboot.module.sys.model;

import java.util.Date;

/**
 * 操作日志实体类
 * @author skotori
 * @date 2019-12-03 09:35
 */
public class SysOperationLog {

    // 主键id
    private Integer id;
    // 账号
    private String account;
    // 操作日志类型(1：新增操作 2：删除操作 3：修改操作)
    private Integer type;
    // 操作时间
    private Date time;
    // 操作ip
    private String ip;
    // 操作名称
    private String name;
    // 方法名
    private String method;
    // 传参
    private String param;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "SysOperationLog{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", type=" + type +
                ", time=" + time +
                ", ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", method='" + method + '\'' +
                ", param='" + param + '\'' +
                '}';
    }
}
