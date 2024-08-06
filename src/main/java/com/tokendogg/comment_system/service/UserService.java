package com.tokendogg.comment_system.service;

import com.tokendogg.comment_system.entity.User;
import com.tokendogg.comment_system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User addNewUser(User user){
        userMapper.addNewUser(user);
        return user;
    }
}
