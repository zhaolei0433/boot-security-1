package com.example.controller;

import com.example.global.constants.SwaggerUIConstants;
import com.example.global.constants.SystemDefines;
import com.example.model.Result;
import com.example.security.model.MyUserDetails;
import com.example.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaolei
 * Create: 2020/2/25 13:46
 * Modified By:
 * Description:
 */
@Api(tags = SwaggerUIConstants.SYSUSER_PC_API)
@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    private ISysUserService sysUserService;

    @Autowired
    public SysUserController(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @ApiOperation(value = "获取系统用户")
    @RequestMapping(value = "/querySysUser", method = RequestMethod.GET)
    @ResponseBody
    public Result<MyUserDetails> getSysUser(String username) throws Exception {

        System.out.println("hhha:"+inMemoryUserDetailsManager.loadUserByUsername(username).getUsername());
        System.out.println("hahah");
        return null;
    }
}
