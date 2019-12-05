package com.skotori.sunzboot.common.jwt;

import com.alibaba.fastjson.JSON;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

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

    private Logger log = LoggerFactory.getLogger(JWTFilter.class);

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
            responseFail(response, "请求头必须携带Authorization字段");
            return false;
        }

        // 执行认证
        if (!executeLogin(request, response)) {
            responseFail(response, "认证失败");
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
        String bearerToken = httpServletRequest.getHeader(ShiroUtil.TOKEN_HEADER);
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
        String token = httpServletRequest.getHeader(ShiroUtil.TOKEN_HEADER).substring(7);
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

    /**
     * 预处理，对跨域提供支持
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    private void responseFail(ServletResponse response, String msg) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        Result result = Result.error(msg);
        String jsonStr = JSON.toJSONString(result);
        try {
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(jsonStr);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            log.error("JWTFilter返回错误信息异常：[ {} ]", e.getMessage());
        }
    }

}
