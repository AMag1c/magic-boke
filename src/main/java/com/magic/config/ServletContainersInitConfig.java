package com.magic.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[ ]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[ ]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[ ]{"/boke/*"};
    }


    //乱码处理
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter =new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}