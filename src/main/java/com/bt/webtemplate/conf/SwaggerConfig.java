/**
* @Author: xiekun
* @Date: 2023-04-18
* @Description: 
*/
package com.bt.webtemplate.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * 配置Swagger2相关信息
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bt.webtemplate.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置Swagger2页面展示信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("WebTemplate API文档")
                .description("WebTemplate API文档")
                .termsOfServiceUrl("http://localhost:8080/")
                .version("1.0")
                .build();
    }
}
