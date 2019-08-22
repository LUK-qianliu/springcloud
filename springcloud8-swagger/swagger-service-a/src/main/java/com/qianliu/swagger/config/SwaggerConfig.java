package com.qianliu.swagger.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qianliu.swagger.controller")) //扫描的包
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))  //扫描@API修饰的类
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) //扫描@ApiOperation修饰的方法
                .paths(PathSelectors.any()) //任意路径都可以匹配
                .build();
    }

    /**
     * swagger入口的title等属性
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("XXX用户系统")
                .description("XXXX系统接口文档说明")
                .contact(new springfox.documentation.service.Contact("XX网", "http://www.xx.com", "xxx@126.com"))
                .version("1.0")
                .build();
    }
}