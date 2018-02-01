package com.learn.springboot.mapper;

import com.learn.springboot.service.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XYJ on 2018/1/15.
 */
//@Repository
public interface UserMapper {
    //保存用户信息：
    @Insert("insert into user_info(username,age) values(#{username},#{age})")
   int saveUserInfo(UserEntity userEntity);

    //根据id查询用户信息
    @Select("select * from user_info where id= #{id}")
    UserEntity queryById(Long id);
    //根据id查询用户信息
    @Select("select * from user_info where username =#{username}")
    List<UserEntity> queryLikeUsername(String username);
}
