package com.example.controller;

import com.example.global.constants.SystemDefines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaolei
 * Create: 2020/3/10 15:16
 * Modified By:
 * Description:
 */
@Controller
public class SysUserLoginController {

    /**
     * 首页
     *
     * @param model
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @RequestMapping(path = {"/", "/index"},method = RequestMethod.GET)
    @ResponseBody
    public String index(Model model, HttpServletRequest httpServletRequest) throws Exception {
        /*model.addAttribute("name", "layui后台系统");
        model.addAttribute("username", httpServletRequest.getSession().getAttribute(SystemDefines.SESSION_USER_NAME));*/
        return "hello this is index! welcome " + getUser();
    }

    public Object getUser() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRemoteUser();
    }

    /**
     * 登录页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() throws Exception {
        return "login";
    }
}
