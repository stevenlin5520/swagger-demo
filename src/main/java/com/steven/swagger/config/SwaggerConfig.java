package com.steven.swagger.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Swagger 配置类
 * @author Steven
 */
@SpringBootConfiguration
@EnableSwagger2     /** 启动Swagger **/
public class SwaggerConfig {
/*

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }
*/

    /**
     * 配置Swagger的Docket的bean实例
     * @return
     */
    @Bean
    public Docket docket(Environment environment){
        /*return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());*/

        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");

        // 根据environment.acceptsProfiles(profiles)判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // Swagger启动配置。true才会开启Swagger，flase则关闭（浏览器不能访问）
                .enable(flag)
                // 配置分组
                .groupName("hello")
                .select()
                // RequestHandlerSelectors  配置要扫描的接口的方式
                // basePackage("包名")    指定要扫描的包
                // any()    扫描全部
                // none()   不进行扫描
                // withMethodAnnotation("类组件注解")   扫描方法上带了**注解的，withMethodAnnotation(GetMapping.class)
                // withClassAnnotation("请求方法注解")    扫描类上带了**注解的，如withClassAnnotation(RestController.class)
                .apis(RequestHandlerSelectors.basePackage("com.steven.swagger.controller"))
                // 过滤扫描路径
                // ant("请求路径")    过滤请求路径为/hello/下的，如nt("/hello")
                // regex("路径")  过滤请求路径为正则表达式下的
                // any()  任何请求都扫描
                // none()  任何请求都不扫描
//                .paths(PathSelectors.ant("/steven/**"))
                .build();

//        return new Docket(DocumentationType.SWAGGER_2)
//                // 是否启动swagger
//                .groupName("lin")
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.steven.swagger.controller"))
//                .build();
    }

    /**
     * 配置Swagger的信息 = ApiInfo
     * @return
     */
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("steven", "https://blog.csdn.net/qq_33799366", "stevenlin5520@outlook.com");
        return new ApiInfo(
                "Steven的Sagger配置接口文档",
                "十年生死两茫茫，不思量，自难忘。千里孤坟，无处话凄凉。",
                "v1.0",
                "https://blog.csdn.net/qq_33799366",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}
