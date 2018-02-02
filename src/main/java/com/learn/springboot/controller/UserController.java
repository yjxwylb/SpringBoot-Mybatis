package com.learn.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.learn.springboot.api.IuserService;
import com.learn.springboot.api.vo.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author XYJ
 * @类描述:
 * @Date:Created in 2018/1/15 17:30
 * @Version:
 */

@RestController
@RequestMapping("/user")
@Api(description = "用户操作接口--SpringBoot整合mybatis 及 Swagger2")
public class UserController {

    @Autowired
    private IuserService userService;

    @ApiOperation(value = "保存用户信息", notes = "保存用户信息")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Integer saveUserInfo(@RequestBody  @ApiParam(value = "用户信息", required = true) UserInfoVO userInfoVO){
       return userService.saveUserInfo(userInfoVO);
    }

    @ApiOperation(value = "根据id查询用户信息", notes = "查询用户信息")
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public UserInfoVO queryById(@RequestParam @ApiParam(value = "用户id", required = true) Long id){
       return userService.queryById(id);
    }

    @ApiOperation(value = "根据用户名模糊查询用户信息", notes = "用户名模糊查询用户信息")
    @RequestMapping(value = "/queryByIdLikeUsername",method = RequestMethod.GET)
    public List<UserInfoVO> queryByNmae(@RequestParam @ApiParam(value = "用户名", required = true) String username){
        //分页查询,注:需要配置类:MyBatisConfiguration
        PageHelper.startPage(2,3);
       return userService.queryLikeUsername(username);
    }


}
