package com.skotori.sunzboot.config;

import com.skotori.sunzboot.common.jwt.JWTFilter;
import com.skotori.sunzboot.common.shiro.ShiroRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 * @author skotori
 * @date 2019-11-07 16:49
 */
@Configuration
public class ShiroConfig {

    /**
     * 配置过滤器资源
     * 配置时必须设置SecurityManager、Filters、FilterChainDefinitionMap，否则会报错
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 过滤链上加入JWTFilter
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("jwt", new JWTFilter());
        shiroFilterFactoryBean.setFilters(filters);

        // 用filterChainDefinitionMap添加拦截的url，其中authc指定需要认证的url，anon指定排除认证的url
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/auth", "anon"); // 登录接口不需要认证
        filterChainDefinitionMap.put("/druid/**", "anon"); // druid接口不需要认证
        filterChainDefinitionMap.put("/**", "jwt"); // 剩下url都要经过JWTFilter
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 配置安全管理器
     * @param shiroCacheManager
     * @return
     */
    @Bean
    public SecurityManager securityManager(CacheManager shiroCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置ShiroRealm
        securityManager.setRealm(this.shiroRealm());
        // 设置CacheManager
        securityManager.setCacheManager(shiroCacheManager);
        return securityManager;
    }

    /**
     * 注入自定义ShiroRealm
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    /**
     * 自定义CacheManager
     * @param ehcache
     * @return
     */
    @Bean
    public CacheManager shiroCacheManager(EhCacheManagerFactoryBean ehcache) {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManager(ehcache.getObject());
        return ehCacheManager;
    }

    /**
     * 开启aop注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

}
