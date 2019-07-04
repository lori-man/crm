package com.mercury.web;

import com.mercury.domain.User;
import com.mercury.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String regist(User user) {
        System.out.println(user);
        userService.regist(user);
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest req, HttpServletResponse resp) {
        User existUser = userService.login(user);
        if (existUser == null) {
            //登入失败
            req.setAttribute("error","用户名和密码错误");
            return "login";
        }else {
            //登入成功
            req.getSession().setAttribute("existUser", existUser);
//            System.out.println(existUser.toString());
            return "index";
        }
    }

    @RequestMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser(User user) {
        List<User> list = userService.findAllUser();
        return list;
    }

    @RequestMapping("/loginout")
    public String loginOut(User user, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("existUser", null);
        return "index";
    }
}
