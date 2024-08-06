package com.tokendogg.comment_system.service;

import com.tokendogg.comment_system.entity.Comment;
import com.tokendogg.comment_system.entity.Post;
import com.tokendogg.comment_system.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    public Post addNewPost(Post post) {

        postMapper.addNewPost(post);

        return post;
    }




}
