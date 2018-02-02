package com.learn.springboot.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: xyj
 * @Description:
 * @CreateTime: 2018/1/24 23:32
 * @Version:
 */

/*@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createUserInfo() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        Contact contact = new Contact("XYJ", "", "yjx_wylb@163.com");
        ApiInfo apiInfo = new ApiInfo("SpringBoot整合mybatis文档", "SpringBoot文档", "V1.0", "", contact, "", "");
        docket.apiInfo(apiInfo);
        return docket;
    }
}*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot整合mybatis文档")
                .description("SpringBoot文档")
                .version("1.0.0")
                .termsOfServiceUrl("/")
                .license("License")
                .licenseUrl("/")
                .build();
    }
}