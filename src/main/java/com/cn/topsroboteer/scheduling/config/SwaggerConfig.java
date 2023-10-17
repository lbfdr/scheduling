package com.cn.topsroboteer.scheduling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @program: rc
 * @description: swagger配置类 。Springfox 的前身是 swagger-springmvc，
 * 是一个开源的 API doc 框架，可以将我们的 Controller 的方法以文档的形式展现。
 * @author: zhaoxianglong
 * @create: 2021-09-03 13:33
 **/
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
       //Docket: 一个构建器，旨在成为 Springfox 框架的主要接口。提供合理的默认值和方便的配置方法
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())//设置 json ResourceListing 响应中包含的 api 元信息
                .select()//启动一个用于 api 选择的构建器
                .apis(RequestHandlerSelectors.basePackage("com.cn.topsroboteer.scheduling"))
                .build();
    }

    /**
     * 构建 api文档的详细信息函数
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()//构建api信息
                .title("九星智元排期系统APIs")//api标题
                .description("九星智元排期系统API接口文档")//更新api描述
                .version("1.0")//更新api版本
                .build();
    }
}
