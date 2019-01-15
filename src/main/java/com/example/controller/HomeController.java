package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:模拟单点登录
 * @Author Ran.chunlin
 * @Date: Created in 15:00 2019-01-13
 */
@Controller
public class HomeController {

    /**
     * 访问主页
     *
     * @return
     */
    @RequestMapping({"/", "/home"})
    public String root() throws ClassNotFoundException {
        return "index";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/auth/login")
    public String login() {
        return "login";
    }

}
