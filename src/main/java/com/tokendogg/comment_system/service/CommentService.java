package com.tokendogg.comment_system.service;

import com.rabbitmq.client.Channel;

import com.tokendogg.comment_system.entity.Comment;
import com.tokendogg.comment_system.entity.Like;
import com.tokendogg.comment_system.mapper.CommentMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;

import static com.tokendogg.comment_system.config.RabbitMQConfig.EXCHANGE_NAME;


@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private Channel rabbitChannel;


    String queue_name_start = "likes.user";

    String routing_key_start = "user.";

    public CommentService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     *
     * @param
     * @return 新增用的 user_id
     */
    public Comment addNewComment(Comment comment){
        if(comment.getParent_comment_id() != null && commentMapper.getCommentById(comment.getParent_comment_id()) == null){
            return null;
        }
        commentMapper.addNewComment(comment);
        return comment;
    }

    public Comment getCommentById(int id){
        return commentMapper.getCommentById(id);
    }

    public Like addNewLike(Like like) throws IOException {
        commentMapper.updateCommentLikes(like.getComment_id());
        commentMapper.addNewLike(like);
        createAndBindQueue(like.getUser_id());
        String routing_key = getRouting_key(like.getUser_id());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,routing_key,like.getLike_id());
        return like;
    }

    public Like receiveMessage(Integer user_id) throws IOException {
        createAndBindQueue(user_id);
        String queue_name = getQueue_name(user_id);
        Object message = rabbitTemplate.receiveAndConvert(queue_name);
        if (message != null) {
            Integer like_id = Integer.parseInt(message.toString());
            return commentMapper.getLikeById(like_id);
        } else {
            return null;
        }
    }

    public List<Comment> getAllComentsSortByLikes(int post_id, int offset){
        List<Comment> comments = commentMapper.getAllCommentsSortByLikes(post_id,10,offset*10);
        this.getALlChildCommentsRecursively(post_id,comments);
        return comments;
    }

    public void getALlChildCommentsRecursively(int post_id,List<Comment> comments){
        for(int i=0;i<comments.size();i++){
            comments.get(i).setChild(commentMapper.getALLChildComments(post_id,comments.get(i).getComment_id()));
            getALlChildCommentsRecursively(post_id,comments.get(i).getChild());
        }
    }

    public String getQueue_name(Integer user_id) {
        return queue_name_start + user_id;
    }

    public String getRouting_key(Integer user_id) {
        return routing_key_start + user_id;
    }

    private void createAndBindQueue(Integer user_id) throws IOException {
        String queue_name = getQueue_name(user_id);
        String routing_key = getRouting_key(user_id);

        String queue = rabbitChannel.queueDeclare(queue_name,true,false,true,null).getQueue();
        rabbitChannel.queueBind(queue,EXCHANGE_NAME,routing_key);

    }

}
