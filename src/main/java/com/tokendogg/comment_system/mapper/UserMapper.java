package com.tokendogg.comment_system.mapper;

import com.tokendogg.comment_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    /**
     * 数据库新增用户
     * @param user
     * @return 新增用的 user_id
     */
    public int addNewUser(User user);

}
