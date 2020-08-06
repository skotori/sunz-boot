package com.skotori.sunzboot.common.log;

/**
 * 日志类型枚举
 * @author skotori
 * @date 2019-12-03 15:01
 */
public enum LogTypeEnum {

    LOGIN_LOG(1, "登录日志"),
    OPERATE_LOG(2, "操作日志");

    Integer code;
    String name;

    LogTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
