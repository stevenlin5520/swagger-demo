package com.steven.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Steven
 */
@ApiModel(value = "实体对象名",description = "实体描述")
public class User {
    @ApiModelProperty(value="用户名",name = "username1",dataType = "String",required = true,example = "李明")
    private String username;
    @ApiModelProperty(value = "密码",hidden = true)
    private String password;
    @ApiModelProperty("年龄")
    private Integer age;

    public User(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
