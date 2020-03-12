package com.example.service.impl;

import com.example.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author zhaolei
 * Create: 2020/3/12 17:54
 * Modified By:
 * Description:
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);

    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public SysUserServiceImpl(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @Override
    public void addSysUser() {

        inMemoryUserDetailsManager.createUser();
    }
}
