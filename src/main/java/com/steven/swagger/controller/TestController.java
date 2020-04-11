package com.steven.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steven
 */
@Api(value="类上的注解")
@RestController
public class TestController {

    @ApiOperation("测试")
    @GetMapping("test")
    public String test(){
        return "test";
    }

     @ApiOperation("测试2")
    @GetMapping("test2")
    public String test2(){
        return "test2";
    }

}
