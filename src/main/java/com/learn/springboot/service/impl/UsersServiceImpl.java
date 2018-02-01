package com.learn.springboot.service.impl;

import com.learn.springboot.api.IuserService;
import com.learn.springboot.api.vo.UserInfoVO;
import com.learn.springboot.mapper.UserMapper;
import com.learn.springboot.service.entity.UserEntity;
import com.learn.springboot.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XYJ
 * @类描述:
 * @Date:Created in 2018/1/15 17:16
 * @Version:
 */

@Service("userService")
public class UsersServiceImpl implements IuserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUserInfo(UserInfoVO userInfoVO) {




        UserEntity userEntity = new UserEntity();
        BeanCopyUtil.copyProperties(userInfoVO, userEntity);
        return userMapper.saveUserInfo(userEntity);
    }

    @Override
    public UserInfoVO queryById(Long id) {

        UserEntity userEntity = userMapper.queryById(id);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanCopyUtil.copyProperties(userEntity,userInfoVO);
        return userInfoVO;
    }
    @Override
    public List<UserInfoVO> queryLikeUsername(String username) {

        List<UserEntity> userEntityList = userMapper.queryLikeUsername(username);
        UserInfoVO userInfoVO = new UserInfoVO();
        List<UserInfoVO> userInfoList = new ArrayList<>();
        userEntityList.forEach((e)->{
            BeanCopyUtil.copyProperties(e,userInfoVO);
            userInfoList.add(userInfoVO);
        });
        return userInfoList;
    }
}
