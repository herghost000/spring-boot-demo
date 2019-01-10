package com.example.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        logger.info("[ShiroConfiguration] Shiro shiroFilter");
        //1.定义shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //2.设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //3.LinkedHashMap是有序的，进行顺序拦截器配置
        Map<String,String> filterChainMap = new LinkedHashMap<String,String>();
        //4.配置logout过滤器
        filterChainMap.put("/logout", "logout");
        //5.所有url必须通过认证才可以访问
        filterChainMap.put("/**","authc");
        //6.设置默认登录的url
        shiroFilterFactoryBean.setLoginUrl("/login");
        //7.设置成功之后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //8.设置未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //9.设置shiroFilterFactoryBean的FilterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 配置安全管理器
     * @author zhengkai
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        logger.info("[ShiroConfiguration] Shiro securityManager");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        return securityManager;
    }
}
