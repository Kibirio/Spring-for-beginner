package com.palmoncodes.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplictionInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
//		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//		webApplicationContext.setConfigLocation("classpath:bean.xml");
		
		// using java annotations instead of xml file
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorApplicationConfig.class);

		// create a dispatcher servlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		// register dispatcher servlet with servlet context
		ServletRegistration.Dynamic customDispatcherServlet = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		
		customDispatcherServlet.setLoadOnStartup(1);
		customDispatcherServlet.addMapping("/mywebsite.com/*");
	}
	

}
