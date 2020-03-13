package com.example.controller;

import com.example.global.constants.SystemDefines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * @param model
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest httpServletRequest) throws Exception {
        model.addAttribute("name","layui后台系统");
        model.addAttribute("username",httpServletRequest.getSession().getAttribute(SystemDefines.SESSION_USER_NAME));
        return "index";
    }

    /**
     * 登录页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() throws Exception {
        return "login";
    }

    /*@RequestMapping("/login_failure")
    public String loginFailure(Model model){
        model.addAttribute("login_error", "用户名或密码错误");
        System.out.println("haaaaaaaaaaaaaa");
        return "loginPage";
    }*/

   /* @RequestMapping("/register")
    public String registerPage() throws Exception {
        return "register1";
    }*/
}
