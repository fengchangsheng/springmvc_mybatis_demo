package com.fcs.user.controller;

import com.fcs.user.model.UserInfo;
import com.fcs.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Lucare.Feng on 2016/1/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showInfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId){
        UserInfo userInfo = userService.getUserById(userId);
        modelMap.addAttribute("userInfo", userInfo);
        System.out.println("________________________>>>>>>>>>>>>>>>>");
        return "/user/showInfo";
    }

    @RequestMapping("/showInfos")
    public @ResponseBody
    Object showUserInfos(){
        List<UserInfo> userInfos = userService.getUsers();
        return userInfos;
    }
}
