package com.lne.fmmall.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * FileName: SwaggerConfig
 * Author:   fengsulin
 * Date:     2022/4/21 21:53
 * Description: Swagger2配置类
 * 注意：SpringBoot高版本缺少swagger运行的环境,这里继承WebMvcConfigurationSupport，重写addResourceHandlers和addViewControllers
 * 方法以重新自定义注册swagger2失效的地址
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{
    /**
     * swagger会帮助我们生成接口文档
     * 1.配置生成的文档信息
     * 2.配置生成规则
     */

    /**Docket封装接口文档信息*/

    @Bean
    public Docket getDocket(){
        //封面信息
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        ApiInfo apiInfo = apiInfoBuilder.title("《风迷商城》后端接口说明")
                .description("此文档详细说明了后端接口的规范")
                .version("v2.0.1")
                .contact(new Contact("林e", "fengsu_lin@163.com", "fengsu_lin@163.com"))
                .build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)// 指定生成文档中的封面信息：标题、描述、版本、作者
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lne.fmmall.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** swagger配置 */

        /**swagger-bootstrap-ui依赖提供界面url处理*/
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        WebMvcConfigurer.super.addResourceHandlers(registry);

        /**swagger-ui依赖提供界面url处理*/
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( "/swagger-ui/")
                .setViewName("forward:/swagger-ui/index.html");
    }

}
