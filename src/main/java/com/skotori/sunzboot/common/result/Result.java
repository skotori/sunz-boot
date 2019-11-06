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

    private Result(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code();
        this.msg = resultCodeEnum.msg();
    }

    private Result(ResultCodeEnum resultCodeEnum, Object data) {
        this.code = resultCodeEnum.code();
        this.msg = resultCodeEnum.msg();
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
        return new Result(ResultCodeEnum.SUCCESS);
    }

    //成功 返回数据
    public static Result success(Object data) {
        return new Result(ResultCodeEnum.SUCCESS, data);
    }

    //失败 不返回失败原因
    public static Result error() {
        return new Result(ResultCodeEnum.ERROR);
    }

    //失败 返回失败原因
    public static Result error(ResultCodeEnum resultCodeEnum) {
        return new Result(resultCodeEnum);
    }

}
