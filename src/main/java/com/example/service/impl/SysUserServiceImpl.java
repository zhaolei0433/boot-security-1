package com.example.service.impl;

import com.example.global.constants.SystemDefines;
import com.example.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaolei
 * Create: 2020/3/12 17:54
 * Modified By:
 * Description:
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*@Autowired
    InMemoryUserDetailsManager inMemoryUserDetailsManager;*/

    @Override
    public void addSysUser(String username, String password) {

        /*User.UserBuilder builder = User.builder().passwordEncoder(passwordEncoder::encode);
        inMemoryUserDetailsManager.createUser(builder.username("zhaolei").password("123456").roles("USER").build());
        System.out.println("!!!!!!"+inMemoryUserDetailsManager.loadUserByUsername("admin").getUsername());*/
    }
}
