package com.zzl.person.controller;

import com.zzl.person.bean.User;
import com.zzl.person.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * 负责登录页面的controller
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        HttpSession session, Model model) {

        User user = loginService.getUserByUsername(username, password);

        if (user != null) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user.getUsername());
            //登录成功重定向到main.html；重定向防止表单的重复提交
            return "redirect:/main";
        } else {
            model.addAttribute("msg", "アカウントのパスワードが正しくありません");
            //回到登录页面
            return "login";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.setAttribute("loginUser",null);
        return "login";
    }

    /**
     * 去main页面
     */
    @GetMapping("/main")
    public String mainPage(){

        return "main";
    }
}
