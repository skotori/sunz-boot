package com.skotori.sunzboot.module.sys.entity;

import java.util.Date;

/**
 * 系统日志实体类
 * @author skotori
 * @date 2019-12-03 09:35
 */
public class SysLog {

    // 主键id
    private Integer id;
    // 来源ip
    private String sourceIp;
    // 来源浏览器
    private String sourceBrowser;
    // 请求url
    private String requestUrl;
    // 请求方法
    private String requestMethod;
    // 请求数据
    private String requestData;
    // 请求时间
    private Date requestTime;
    // 请求用户
    private String requestUser;
    // 响应状态(0：失败 1：成功)
    private Integer responseState;
    // 响应数据
    private String responseData;
    // 执行方法
    private String executeMethod;
    // 执行信息
    private String executeMsg;
    // 执行耗时
    private long executeTime;
    // 异常信息
    private String exceptionMsg;
    // 日志类型(1：登录日志 2：操作日志)
    private Integer logType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getSourceBrowser() {
        return sourceBrowser;
    }

    public void setSourceBrowser(String sourceBrowser) {
        this.sourceBrowser = sourceBrowser;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(String requestUser) {
        this.requestUser = requestUser;
    }

    public Integer getResponseState() {
        return responseState;
    }

    public void setResponseState(Integer responseState) {
        this.responseState = responseState;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public String getExecuteMethod() {
        return executeMethod;
    }

    public void setExecuteMethod(String executeMethod) {
        this.executeMethod = executeMethod;
    }

    public String getExecuteMsg() {
        return executeMsg;
    }

    public void setExecuteMsg(String executeMsg) {
        this.executeMsg = executeMsg;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", sourceIp='" + sourceIp + '\'' +
                ", sourceBrowser='" + sourceBrowser + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", requestData='" + requestData + '\'' +
                ", requestTime=" + requestTime +
                ", requestUser='" + requestUser + '\'' +
                ", responseState=" + responseState +
                ", responseData='" + responseData + '\'' +
                ", executeMethod='" + executeMethod + '\'' +
                ", executeMsg='" + executeMsg + '\'' +
                ", executeTime='" + executeTime + '\'' +
                ", exceptionMsg='" + exceptionMsg + '\'' +
                ", logType=" + logType +
                '}';
    }
}
