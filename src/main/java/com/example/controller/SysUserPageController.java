package com.example.controller;

import com.example.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaolei
 * Create: 2020/2/25 17:13
 * Modified By:
 * Description:
 */
@Controller
@RequestMapping(value = "systemManagePage")
public class SysUserPageController {

    private ISysUserService sysUserService;

    @Autowired
    public SysUserPageController(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
}
