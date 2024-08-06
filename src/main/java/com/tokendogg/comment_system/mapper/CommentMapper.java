package com.tokendogg.comment_system.mapper;

import com.tokendogg.comment_system.entity.Comment;
import com.tokendogg.comment_system.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CommentMapper {

    /**
     * 数据库添加新评论
     * @param comment
     * @return 添加是否成功
     */
    public int addNewComment(Comment comment);

    /**
     * 通过评论id查找评论
     * @param id
     * @return 查找到的评论
     */
    public Comment getCommentById(int id);

    /**
     * 数据库添加点赞记录
     * @param like
     * @return 添加是否成功
     */
    public int addNewLike(Like like);

    /**
     * 通过点赞id查找点赞记录
     * @param like_id
     * @return 查找到的点赞记录
     */
    public Like getLikeById(Integer like_id);

    /**
     * 更新点赞数量
     * @param id
     * @return 是否成功
     */
    public int updateCommentLikes(Integer id);

    /**
     * 按页查找帖子下的所有评论
     * @param post_id,limit,offset
     * @return 返回该页下的评论
     */
    public List<Comment> getAllCommentsSortByLikes(Integer post_id,int limit, int offset);

    /**
     * 查找父评论下的所有子评论
     * @param post_id,parent_comment_id
     * @return 返回父评论下的所有子评论
     */
    public List<Comment> getALLChildComments(Integer post_id, Integer parent_comment_id);

}
