package com.lori.controller;

import com.lori.entity.User;
import com.lori.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public String regist(User user) {
        System.out.println(user);
        userService.regist(user);
        return "login";
    }

    @RequestMapping("login")
    public String login(User user, HttpServletRequest req, HttpServletResponse resp) {
        User existUser = userService.login(user);
        if (existUser == null) {
            //登入失败
            req.setAttribute("error","用户名和密码错误");
            return "login";
        }else {
            //登入成功
            req.getSession().setAttribute("existUser", existUser);
            System.out.println(existUser.toString());
            return "redirect:/index.jsp";
        }
    }
}
