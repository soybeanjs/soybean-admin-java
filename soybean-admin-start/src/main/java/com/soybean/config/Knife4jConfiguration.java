package com.soybean.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j / OpenAPI 3 文档配置，访问地址：/doc.html
 *
 * @author soybean
 * @since 2024-09-15
 */
@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .description("# soybean RESTful APIs")
                .termsOfService("https://doc.soybean.com/")
                .contact(new Contact().name("soybean"))
                .version("1.0"));
    }

    @Bean
    public GroupedOpenApi baseApi() {
        return GroupedOpenApi.builder()
                //分组名称
                .group("基础服务")
                //这里指定Controller扫描包路径
                .packagesToScan("com.soybean")
                .pathsToMatch("/**")
                .build();
    }
}
