package com.tokendogg.comment_system.controller;

import com.tokendogg.comment_system.entity.User;
import com.tokendogg.comment_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 插入新用户 提供username
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public User insert(User user){
        return userService.addNewUser(user);
    }
}