package com.tokendogg.comment_system.controller;

import com.tokendogg.comment_system.config.RabbitMQConfig;
import com.tokendogg.comment_system.entity.Comment;
import com.tokendogg.comment_system.entity.Like;
import com.tokendogg.comment_system.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;



    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Comment insert(Comment comment){
        Comment newComment = commentService.addNewComment(comment);
//        if(newComment == null){
//            return "wrong info";
//        }
        return newComment;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Comment getUserById(int id){
        Comment comment = commentService.getCommentById(id);
        return comment;
    }

    @RequestMapping(value = "like", method = RequestMethod.GET)
    public Like addNewLike(Like like) throws IOException {
        Like new_like = commentService.addNewLike(like);
        return new_like;
    }

    @RequestMapping(value = "/comments-likes", method = RequestMethod.GET)
    public List<Comment> getCommentsSortByLikes(int post_id, int page){
        List<Comment> result  = commentService.getAllComentsSortByLikes(post_id,page);
        return result;
    }

    @RequestMapping(value = "receive-like",method = RequestMethod.GET)
    public Like recieveNewLikes(Integer user_id) throws IOException {
        return commentService.receiveMessage(user_id);
    }


}
