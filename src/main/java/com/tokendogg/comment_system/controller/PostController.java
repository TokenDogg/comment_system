package com.tokendogg.comment_system.controller;

import com.tokendogg.comment_system.entity.Comment;
import com.tokendogg.comment_system.entity.Post;
import com.tokendogg.comment_system.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Post insert(Post post){
        return postService.addNewPost(post);
    }

}
