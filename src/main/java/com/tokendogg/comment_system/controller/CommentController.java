package com.tokendogg.comment_system.controller;

import com.tokendogg.comment_system.config.RabbitMQConfig;
import com.tokendogg.comment_system.entity.Comment;
import com.tokendogg.comment_system.entity.CustomJSONResponse;
import com.tokendogg.comment_system.entity.Like;
import com.tokendogg.comment_system.entity.Post;
import com.tokendogg.comment_system.service.CommentService;
import com.tokendogg.comment_system.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Comment> insert(Comment comment){
        Comment newComment = commentService.addNewComment(comment);

        return new ResponseEntity<>(newComment,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<Object> getCommentById(int id){
        Comment comment = commentService.getCommentById(id);
        if(comment == null){
            CustomJSONResponse response = new CustomJSONResponse("评论不存在");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(comment,HttpStatus.CREATED);
    }

    @RequestMapping(value = "like", method = RequestMethod.GET)
    public ResponseEntity<Like> addNewLike(Like like) throws IOException {
        Like new_like = commentService.addNewLike(like);
        return new ResponseEntity<>(new_like,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/comments-under-post", method = RequestMethod.GET)
    public ResponseEntity<Object> getCommentsSortByLikes(int post_id, int page,String sort_by){
        Post post = postService.getPostById(post_id);
        if(post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Comment> result  = commentService.getCommentsByPages(post_id,page,sort_by);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @RequestMapping(value = "receive-like",method = RequestMethod.GET)
    public ResponseEntity<Object> recieveNewLikes(Integer user_id) throws IOException {

        Like like = commentService.receiveMessage(user_id);
        return new ResponseEntity<>(like,HttpStatus.CREATED);
    }

}
