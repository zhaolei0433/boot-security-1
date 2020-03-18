package com.example.config;

import com.example.security.myhander.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

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

    @Resource
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 认证管理器配置
     * 通过覆盖实现该方法，开发人员可以定制认证机制，比如设置成基于内存的认证，基于数据库的认证，基于LDAP的认证，甚至这些认证机制的一个组合，
     * 设置AuthenticationManager的双亲关系，所使用的PasswordEncoder等等；
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder builder = User.builder().passwordEncoder(passwordEncoder()::encode);
        auth
                .inMemoryAuthentication()
                .withUser(builder.username("zhaolei").password("123456").roles("USER").build())
                .withUser(builder.username("admin").password("123456").roles("USER").build());
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
                .and().formLogin()
                .loginPage("/login")
                .successHandler(myAuthenticationSuccessHandler);
        // 关闭csrf
        http.csrf().disable();
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
}
