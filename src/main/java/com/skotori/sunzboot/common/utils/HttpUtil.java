package com.skotori.sunzboot.common.utils;

import com.skotori.sunzboot.common.jwt.JWTUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http请求工具类
 * @author skotori
 * @date 2019-11-28 15:03
 */
public class HttpUtil {

    // token头名
    public static final String TOKEN_HEADER = "Authorization";

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getResponse();
    }

    public static String getIp() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public static String getBrowser() {
        String ua = getRequest().getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        Browser browser = userAgent.getBrowser();
        return browser.getName();
    }

    public static String getUrl() {
        return getRequest().getRequestURL().toString();
    }

    public static String getMethod() {
        return getRequest().getMethod();
    }

    public static String getToken() {
        if (getRequest().getHeader(TOKEN_HEADER) != null) {
            return getRequest().getHeader(TOKEN_HEADER).substring(7);
        }
        return null;
    }

    public static String getAccount() {
        if (getToken() != null) {
            return JWTUtil.getAccount(getToken());
        }
        return null;
    }

}
