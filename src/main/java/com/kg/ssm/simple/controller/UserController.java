package com.kg.ssm.simple.controller;

import com.kg.ssm.simple.entity.User;
import com.kg.ssm.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/showname", method = RequestMethod.GET)
    public String showUserName(@RequestParam("uid") int uid, HttpServletRequest request, Model model) {
        System.out.println("showname");
        User user = userService.getById(uid);
        if (user != null) {
            request.setAttribute("name", user.getUserName());
            model.addAttribute("mame", user.getUserName());
            return "user/showName";
        }
        request.setAttribute("error", "没有找到该用户！");
        return "error/error";
    }

}
