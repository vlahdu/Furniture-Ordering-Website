package com.ex;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/designer").setViewName("designer");
        registry.addViewController("/customer").setViewName("customer");
        registry.addViewController("/company").setViewName("company");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("views/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/test1").setViewName("test1");
    }
    public void addResourceHandlers(final ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/**",
                "/css/**",
                "/resources/**",
                "/js/**",
                "/images/**",
                "/api/**",
                "/font-awesome/**"

        )
                .addResourceLocations(
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "classpath:/static/images/",
                        "classpath:/static/api/",
                        "classpath:/resources/",
                        "classpath:/static/font-awesome/");
    }

}