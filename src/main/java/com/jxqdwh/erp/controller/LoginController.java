package com.jxqdwh.erp.controller;

import com.jxqdwh.erp.entity.Users;
import com.jxqdwh.erp.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("index")
    public String index() {
        return "login";
    }
    @RequestMapping("login")
    public String login(Integer userid, String password, Model model) {


        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userid.toString(), password);
        System.out.println("name =" + userid);
        System.out.println("password = " + password);
        //3.执行登录方法
        try {
            System.out.println("执行登录方法");
            //假设数据库用户名和密码 tc 123
            subject.login(token);
            return "/index";
            //登录成功

        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败 用户名不存在
            System.out.println("用户名不存在");
            model.addAttribute("msg", "用户名不存在");
            return "/login";
        } catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败;密码错误
            System.out.println("密码错误");
            model.addAttribute("msg", "密码错误");
            return "/login";
        }
    }

    @GetMapping("noAuth")
    public String noAuth( ) {

        return "noAuth";
    }
}
