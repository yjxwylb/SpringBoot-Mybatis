package com.learn.springboot.service.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author XYJ
 * @类描述:
 * @Date:Created in 2018/1/15 9:21
 * @Version:
 */

@Data
@ToString
public class UserEntity {

    private Long id;
    private String username;
    private Integer age;
}
