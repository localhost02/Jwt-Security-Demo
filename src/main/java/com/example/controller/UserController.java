package com.example.controller;

import cn.localhost01.annotation.RequireAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 用户控制层
 * @Author Ran.chunlin
 * @Date: Created in 14:12 2019-01-13
 */
@RequestMapping("/user") @Controller public class UserController {

    /**
     * 获取用户基本信息
     *
     * @return
     */
    @RequireAuthority("account_users_info")
    @GetMapping("/info") public String info() {
        return "user/info";
    }
}
