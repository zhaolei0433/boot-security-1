package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

/**
 * @author zhaolei
 * Create: 2020/3/12 14:41
 * Modified By:
 * Description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth.skip.antMatchers}")
    private String[] auth_skip_antMatchers;

    /**
     * 认证管理器配置
     * 通过覆盖实现该方法，开发人员可以定制认证机制，比如设置成基于内存的认证，基于数据库的认证，基于LDAP的认证，甚至这些认证机制的一个组合，
     * 设置AuthenticationManager的双亲关系，所使用的PasswordEncoder等等；
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("zhaolei").password("123456").roles("USER");
    }

    /**
     * 核心过滤器
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().and().ignoring().antMatchers("/css/**", "/js/**", "/image/**");
    }

    /**
     *  安全过滤器链
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(auth_skip_antMatchers).permitAll()
                .antMatchers("/index").hasRole("USER")
                .and().formLogin()
                .loginPage("/login")
                .successForwardUrl("/index");
    }
}
