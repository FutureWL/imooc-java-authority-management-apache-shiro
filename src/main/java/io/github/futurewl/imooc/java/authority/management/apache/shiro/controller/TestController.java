package io.github.futurewl.imooc.java.authority.management.apache.shiro.controller;

import io.github.futurewl.imooc.java.authority.management.apache.shiro.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 功能描述：
 *
 * @author weilai create by 2019-04-17:19:30
 * @version 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping("/admin")
    public String admin() {
        return "admin success";
    }

    @ResponseBody
    @RequestMapping("/edit")
    public String edit() {
        return "edit success";
    }

    @RequestMapping(value = "/loginUser")
    public String loginUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session
    ) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }
    }

}
