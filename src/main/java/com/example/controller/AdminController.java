package com.example.controller;

import cn.localhost01.annotation.RequireAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 管理员控制层
 * @Author Ran.chunlin
 * @Date: Created in 14:12 2019-01-13
 */
@RequestMapping("/admin") @Controller public class AdminController {

    /**
     * 创建用户页面
     *
     * @return
     */
    @RequireAuthority("account_users_create")
    @GetMapping("/create") public String create() {
        return "admin/create_user";
    }

    /**
     * 创建用户
     * @return
     */
    @RequireAuthority("account_users_create")
    @PostMapping("/create") public String postCreate() {
        return "admin/create_user_success";
    }
}
