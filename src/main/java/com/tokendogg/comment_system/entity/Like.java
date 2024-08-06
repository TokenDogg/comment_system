package com.tokendogg.comment_system.entity;

public class Like {
    private Integer like_id;
    private Integer comment_id;
    private Integer user_id;

    private Integer liked_by;

    public Integer getLike_id() {
        return like_id;
    }

    public void setLike_id(Integer like_id) {
        this.like_id = like_id;
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

    public Integer getLiked_by() {
        return liked_by;
    }

    public void setLiked_by(Integer liked_by) {
        this.liked_by = liked_by;
    }

    @Override
    public String toString() {
        return "Like{" +
                "like_id=" + like_id +
                ", comment_id=" + comment_id +
                ", user_id=" + user_id +
                '}';
    }
}
