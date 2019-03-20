package com.ma.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig {
   
	@Bean
	public HandlerMapping urlHandlerMapping() {
		Properties properties=null;
		SimpleUrlHandlerMapping simpleUrlHandlerMapping=null;
		
		properties=new Properties();
		properties.put("/welcome-annotation.htm","viewWelcomeAnnotation");
		
		simpleUrlHandlerMapping=new SimpleUrlHandlerMapping();
		simpleUrlHandlerMapping.setMappings(properties);
		
		return simpleUrlHandlerMapping;
	}
	
	@Bean(name="viewWelcomeAnnotation")
	public Controller viewController() {
		ParameterizableViewController controller=null;
		
		controller=new ParameterizableViewController();
		controller.setViewName("welcome-annotation");
		
		return controller;
	}
	
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver=null;
		
		resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
}
