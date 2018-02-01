package com.learn.springboot.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author XYJ
 * @类描述:
 * @Date:Created in 2018/1/15 17:14
 * @Version:
 */
@Data
@ToString
@ApiModel
public class UserInfoVO implements Serializable {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",example = "张三")
    private String username;
    @ApiModelProperty(value = "年龄",example = "18")
    private Integer age;
}
