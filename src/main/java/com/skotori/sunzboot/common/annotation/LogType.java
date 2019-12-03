package com.skotori.sunzboot.common.annotation;

/**
 * 日志类型枚举
 * @author skotori
 * @date 2019-12-03 15:01
 */
public enum LogType {

    INSERT_LOG(1, "新增操作日志"),
    DELETE_LOG(2, "删除操作日志"),
    UPDATE_LOG(3, "更新操作日志");

    Integer code;
    String msg;

    LogType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
