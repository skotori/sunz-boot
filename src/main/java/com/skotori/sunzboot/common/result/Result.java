package com.skotori.sunzboot.common.result;

/**
 * 通用返回
 * @author skotori
 * @date 2019/11/06 20:40
 */
public class Result {

    private Integer code;

    private String msg;

    private Object data;

    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //成功 不返回数据
    public static Result success() {
        return new Result(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.msg());
    }

    //成功 返回数据
    public static Result success(Object data) {
        return new Result(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.msg(), data);
    }

    //失败 不返回失败原因
    public static Result error() {
        return new Result(ResultCode.ERROR.code(), ResultCode.ERROR.msg());
    }

    //失败 返回失败原因
    public static Result error(ResultCode resultCode) {
        return new Result(resultCode.code(), resultCode.msg());
    }

    //失败 返回自定义失败原因
    public static Result error(String msg) {
        return new Result(0, msg);
    }

}
