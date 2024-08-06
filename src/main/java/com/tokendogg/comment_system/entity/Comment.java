package com.tokendogg.comment_system.entity;

import java.util.List;

public class Comment {

    private Integer comment_id;
    private Integer post_id;
    private Integer user_id;
    private Integer parent_comment_id;
    private String content;

    private Integer num_likes;

    private List<Comment> child;

    private String created_at;

    public Integer getNum_likes() {
        return num_likes;
    }

    public void setNum_likes(Integer num_likes) {
        this.num_likes = num_likes;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getChild() {
        return child;
    }

    public void setChild(List<Comment> child) {
        this.child = child;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", post_id=" + post_id +
                ", user_id=" + user_id +
                ", parent_comment_id=" + parent_comment_id +
                ", content='" + content + '\'' +
                ", num_likes=" + num_likes +
                ", child=" + child +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
