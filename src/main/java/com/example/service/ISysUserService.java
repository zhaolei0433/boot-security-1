package com.example.service;

import com.example.security.model.MyUserDetails;

import java.util.List;

/**
 * @author zhaolei
 * Create: 2020/2/25 13:45
 * Modified By:
 * Description:
 */
public interface ISysUserService {

    void addSysUser(String username, String password);

    MyUserDetails getSysUser(String username);
}
