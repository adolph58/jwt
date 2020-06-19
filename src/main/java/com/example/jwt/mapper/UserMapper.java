package com.example.jwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.jwt.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * (User)表数据库访问层
 *
 * @author arte
 * @since 2020-06-18 21:19:31
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT id, username, password FROM user WHERE username=#{username}")
    User getUserByUsername(@Param("username") String username);
}