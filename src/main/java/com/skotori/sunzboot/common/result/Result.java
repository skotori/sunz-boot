package com.skotori.sunzboot.common.result;

/**
 * 通用返回
 * @author skotori
 * @date 2019/11/06 20:40
 */
public class Result {

    // 返回状态
    private String status;
    // 返回信息
    private String message;
    // 返回数据
    private Object data;

    private Result(String status, String message) {
        this.status = status;
        this.message = message;
    }

    private Result(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // 成功 返回默认信息，不返回数据
    public static Result success() {
        return new Result(ResultEnum.SUCCESS.status(), ResultEnum.SUCCESS.message());
    }

    // 成功 返回自定义信息，不返回数据
    public static Result success(String message) {
        return new Result(ResultEnum.SUCCESS.status(), message);
    }

    // 成功 返回默认信息和数据
    public static Result success(Object data) {
        return new Result(ResultEnum.SUCCESS.status(), ResultEnum.SUCCESS.message(), data);
    }

    // 成功 返回自定义信息和数据
    public static Result success(String message, Object data) {
        return new Result(ResultEnum.SUCCESS.status(), message, data);
    }

    // 成功 返回枚举，不返回数据
    public static Result success(ResultEnum resultEnum) {
        return new Result(resultEnum.status(), resultEnum.message());
    }

    // 成功 返回枚举和数据
    public static Result success(ResultEnum resultEnum, Object data) {
        return new Result(resultEnum.status(), resultEnum.message(), data);
    }

    // 失败 返回默认信息
    public static Result error() {
        return new Result(ResultEnum.ERROR.status(), ResultEnum.ERROR.message());
    }

    // 失败 返回自定义信息
    public static Result error(String message) {
        return new Result(ResultEnum.ERROR.status(), message);
    }

    // 失败 返回枚举
    public static Result error(ResultEnum resultEnum) {
        return new Result(resultEnum.status(), resultEnum.message());
    }
}
