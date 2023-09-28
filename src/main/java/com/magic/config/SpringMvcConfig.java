package com.magic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.StandardCharsets;

@Configuration
@ComponentScan({"com.magic.controller"})
@EnableWebMvc
@Import({SpringMvcSupport.class})
public class SpringMvcConfig {

    //文件上传
    @Bean()
    public CommonsMultipartResolver multipartResolver(){

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        // 上传限制最大字节数 -1表示没限制
        commonsMultipartResolver.setMaxUploadSize(-1);
        // 每个文件限制最大字节数 -1表示没限制
        commonsMultipartResolver.setMaxUploadSizePerFile(-1);
        commonsMultipartResolver.setDefaultEncoding(StandardCharsets.UTF_8.name());

        return commonsMultipartResolver;
    }

}
