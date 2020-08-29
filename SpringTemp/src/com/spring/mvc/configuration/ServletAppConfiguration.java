package com.spring.mvc.configuration;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.*;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.spring.mvc",useDefaultFilters = false, 
							 includeFilters = @ComponentScan.Filter(Controller.class))
public class ServletAppConfiguration implements WebMvcConfigurer{
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/views/", ".jsp");
    }
}
