package com.skotori.sunzboot.common.jwt;

import com.alibaba.fastjson.JSON;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.result.ResultEnum;
import com.skotori.sunzboot.common.utils.HttpUtil;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * jwt过滤器，代码的执行流程preHandle->isAccessAllowed->isLoginAttempt->executeLogin
 * @author skotori
 * @date 2019-11-08 11:20
 */
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(JWTFilter.class);

    /**
     * 判断请求是否允许访问
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        // 判断请求是否需要认证
        if (!isLoginAttempt(request, response)) {
            returnError(response, ResultEnum.NOT_FOUND_AUTHORIZATION);
            return false;
        }

        // 执行认证
        if (!executeLogin(request, response)) {
            returnError(response, ResultEnum.AUTHENTICATION_NO_ACCESS);
            return false;
        }

        return true;
    }

    /**
     * isAccessAllowed调用executeLogin后返回false，会执行onAccessDenied重新调用executeLogin，所以这里重写后直接返回false
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        return false;
    }

    /**
     * 判断请求是否需要认证，检测header是否包含Authorization字段即可
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String bearerToken = httpServletRequest.getHeader(HttpUtil.TOKEN_HEADER);
        return bearerToken != null;
    }

    /**
     * 执行认证，交给ShiroRealm即可
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(HttpUtil.TOKEN_HEADER).substring(7);
        JWTToken jwtToken = new JWTToken(token);
        try {
            // 提交给ShiroRealm进行认证
            getSubject(request, response).login(jwtToken);
            return true;
        } catch (Exception e) {
            log.error("认证异常：[ {} ]", e.getMessage());
            return false;
        }
    }

    private void returnError(ServletResponse response, ResultEnum resultEnum) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        Result result = Result.error(resultEnum);
        String jsonStr = JSON.toJSONString(result);
        PrintWriter writer = null;
        try {
            writer = httpServletResponse.getWriter();
            writer.write(jsonStr);
        } catch (IOException e) {
            log.error("JWTFilter返回错误信息异常：[ {} ]", e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }

}
