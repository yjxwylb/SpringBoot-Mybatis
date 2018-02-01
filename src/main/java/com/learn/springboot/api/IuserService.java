package com.learn.springboot.api;

import com.learn.springboot.api.vo.UserInfoVO;

import java.util.List;

/**
 * Created by XYJ on 2018/1/15.
 */
public interface IuserService {
    int saveUserInfo(UserInfoVO userInfoVO);

    UserInfoVO queryById(Long id);

    List<UserInfoVO> queryLikeUsername(String username);
}
