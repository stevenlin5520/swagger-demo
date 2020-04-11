package com.steven.swagger.controller;

import com.steven.swagger.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Steven
 */
@RestController
@Api(value = "可替代@Api",tags={"Hello","Hello模块"})
public class HelloController {

    @ApiIgnore
    @GetMapping("hello")
    public String hello(){
        return "hello，swagger";
    }

    @ApiOperation(value="接口名称",notes = "接口详细说明",tags = "接口分组")
    @PostMapping("user")
    public User user(){
        return new User("李明","liming",23);
    }

    @ApiOperation("请求用户数据2")
    @PostMapping("user2")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功",response = Exception.class),
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public User user2(@ApiParam(name="name",value="用户名",required = true) String username,
                     @ApiParam("用户密码") String password,
                     @ApiParam("用户生日") Integer age){
        return new User(username,password,age);
    }

    @ApiOperation("请求用户数据3")
    @PostMapping("user3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "名字",defaultValue = "默认值",
                    required = true,dataType = "String",paramType = "query",example = "李明"),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "123456",
                    required = true,dataType = "int",paramType = "query",example = "123"),
            @ApiImplicitParam(name="age")
    })
    public User user3(@RequestParam String username, @RequestParam String password, @RequestParam Integer age){
        return new User(username,password,age);
    }

}
