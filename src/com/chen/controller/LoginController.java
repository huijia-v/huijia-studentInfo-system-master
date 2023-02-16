package com.chen.controller;

import com.chen.pojo.Student;
import com.chen.pojo.User;
import com.chen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/autho")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @RequestMapping("/login")
    public String login(Model model, User user, HttpServletRequest request, HttpServletResponse response) {

        User flag = loginService.login(user.getIdNumber(), user.getPassword());

        Integer authority = user.getAuthority();
        if (flag != null && flag.getPassword().equals(user.getPassword()) ) {


            HttpSession session = request.getSession();
            session.setAttribute("name", flag.getName());

            if (authority.equals(flag.getAuthority()) && authority == 0) {

                System.out.println("管理员登录成功");
                return "adminHome";
            } else if (authority.equals(flag.getAuthority()) && authority == 1) {

                System.out.println("教师登录成功");
                return "index";
            } else if (authority.equals(flag.getAuthority()) && authority == 2){

                System.out.println("学生登录成功");
                return "studentHome";
            }else {
                System.out.println("登录失败,用户权限有误");
                model.addAttribute("msg", "登录失败！用户权限有误");
                return "login";
            }

        } else {

            System.out.println("登录失败");
            model.addAttribute("msg", "登录失败！用户名或密码错误！");
            return "login";
        }


    }



    @RequestMapping("/userexit")
    public String UserExit(User user, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.setAttribute("name", user.getName());
        if (user != null) {
            session.removeAttribute("userName");
            request.setAttribute("info", null);
        }

        return "logoff";
    }

    @RequestMapping("/updatepad")
    public String updatePassword(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String loginedUser = (String) session.getAttribute("name");
        System.out.println(loginedUser);
        String oldPwd = request.getParameter("oldpass");
        System.out.println(oldPwd);
        String newPwd = request.getParameter("newpass");
        System.out.println(newPwd);


        Student student = loginService.queryStudentById(loginedUser);
        System.out.println(student);
        if (student.getStudentPad().equals(oldPwd)) {
            int r = loginService.updateStudentPad(student.getStudentId(), newPwd);
            if (r > 0) {
                model.addAttribute("msg", "更新成功！");
                System.out.println("更新成功！");
            } else {
                model.addAttribute("msg", "更新失败！");
                System.out.println("更新失败2！");
            }
        } else {
            model.addAttribute("msg", "密码错误！");
            System.out.println("更新失败！");
        }

        return "updatepad";
    }
}
