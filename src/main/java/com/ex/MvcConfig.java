package com.ex;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/designer").setViewName("designer");
        registry.addViewController("/customer").setViewName("customer");
        registry.addViewController("/company").setViewName("company");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("views/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

}