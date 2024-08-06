package com.tokendogg.comment_system.mapper;

import com.tokendogg.comment_system.entity.Comment;
import com.tokendogg.comment_system.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {

    /**
     * 数据库新增帖子
     * @param post
     * @return 新增用的 post_id
     */
    public int addNewPost(Post post);



}
