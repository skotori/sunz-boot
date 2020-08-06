package com.skotori.sunzboot.common.result;

/**
 * 通用返回枚举
 * @author skotori
 * @date 2019/11/06 20:41
 */
public enum ResultEnum {

    /* 成功状态码 */
    SUCCESS("1", "成功"),
    /* 失败状态码 */
    ERROR("0", "失败"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID("10001", "参数无效"),
    PARAM_IS_BLANK("10002", "参数为空"),
    PARAM_TYPE_BIND_ERROR("10003", "参数类型错误"),
    PARAM_NOT_COMPLETE("10004", "参数缺失"),

    /* 账户错误：20001-29999*/
    USER_NOT_EXIST("20001", "账户不存在"),
    USER_ACCOUNT_FORBIDDEN("20002", "账号已禁用"),
    USER_ACCOUNT_DELETE("20003", "账号已删除"),
    USER_LOGIN_ERROR("20004", "账号或密码错误"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST("30001", "某业务出现问题"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR("40001", "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    SOURCE_DATA_NONE("50001", "数据未找到"),
    DATA_IS_WRONG("50002", "数据有误"),
    DATA_ALREADY_EXISTED("50003", "数据已存在"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR("60001", "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR("60002", "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT("60003", "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID("60004", "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT("60005", "接口请求超时"),
    INTERFACE_EXCEED_LOAD("60006", "接口负载过高"),

    /* 权限错误：70001-79999 */
    NOT_FOUND_AUTHORIZATION("70001", "请求头必须携带Authorization字段"),
    AUTHENTICATION_NO_ACCESS("70002", "认证失败"),
    PERMISSION_NO_ACCESS("70003", "权限不足");

    private final String status;

    private final String message;

    ResultEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String status() {
        return this.status;
    }

    public String message() {
        return this.message;
    }

    public static String getStatus(String name) {
        for (ResultEnum item : ResultEnum.values()) {
            if (item.name().equals(name)) {
                return item.status;
            }
        }
        return null;
    }

    public static String getMessage(String name) {
        for (ResultEnum item : ResultEnum.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
