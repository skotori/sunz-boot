package com.skotori.sunzboot.common.jwt;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jwt过滤器，代码的执行流程preHandle->isAccessAllowed->isLoginAttempt->executeLogin
 * @author skotori
 * @date 2019-11-08 11:20
 */
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private Logger log = LoggerFactory.getLogger(JWTFilter.class);

    private static final String TOKEN_HEADER = "Authorization";

    /**
     * 判断请求是否允许访问
     * @param request
     * @param response
     * @param mappedValue
     * @return
     * @throws UnauthorizedException
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        // 请求白名单
        String[] anonUrls = {"/auth"};
        AntPathMatcher pathMatcher = new AntPathMatcher();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        for (String anonUrl : anonUrls) {
            if (pathMatcher.match(url, anonUrl)) {
                return true;
            }
        }

        // 判断请求是否需要认证
        if (!isLoginAttempt(request, response)) {
            throw new UnauthorizedException("请求头必须携带Authorization字段");
        }

        // 执行认证
        if (!executeLogin(request, response)) {
            throw new UnauthorizedException("校验token失败");
        }

        return true;
    }

    /**
     * 判断请求是否需要认证，检测header是否包含Authorization字段即可
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String bearerToken = req.getHeader(TOKEN_HEADER);
        return bearerToken != null;
    }

    /**
     * 执行认证
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN_HEADER).substring(7);
        JWTToken jwtToken = new JWTToken(token);
        try {
            // 提交给ShiroRealm进行登录
            getSubject(request, response).login(jwtToken);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
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

}
