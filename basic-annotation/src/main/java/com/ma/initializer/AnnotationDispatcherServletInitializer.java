package com.ma.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ma.config.RootConfig;
import com.ma.config.WebMvcConfig;

public class AnnotationDispatcherServletInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
       AnnotationConfigWebApplicationContext rootApplicationContext=null;
       AnnotationConfigWebApplicationContext servletApplicationContext=null;
       ContextLoaderListener contextLoaderListener=null;
       DispatcherServlet dispatcherServlet=null;
       
       rootApplicationContext=new AnnotationConfigWebApplicationContext();
       rootApplicationContext.register(RootConfig.class);
       
       contextLoaderListener=new ContextLoaderListener(rootApplicationContext);
       servletContext.addListener(contextLoaderListener);
       
       servletApplicationContext=new AnnotationConfigWebApplicationContext();
       servletApplicationContext.register(WebMvcConfig.class);
       
       dispatcherServlet=new DispatcherServlet(servletApplicationContext);
       ServletRegistration.Dynamic sConfig=servletContext.addServlet("dispatcher", dispatcherServlet);
       System.out.println(sConfig.getClassName());
       sConfig.setLoadOnStartup(2);
       sConfig.addMapping("*.htm");
	}

}
