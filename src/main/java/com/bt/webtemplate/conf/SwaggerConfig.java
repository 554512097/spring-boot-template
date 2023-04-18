/**
* *****************************************************************************
* Copyright © 1998 - 2020 CSG Shenzhen Digital Grid Research Institute Co.,Ltd.
* All Rights Reserved.
* 本软件为南方电网深圳数字电网研究院有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
* 复制、修改或发布本软件.
* <p>
*
* @Author: xiekun
* @Date: 2023-04-18
* @Description: 
* ****************************************************************************
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
