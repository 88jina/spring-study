package com.configurations;

import javax.servlet.*;

import org.springframework.web.*;
import org.springframework.web.context.*;
import org.springframework.web.context.support.*;
import org.springframework.web.filter.*;
import org.springframework.web.servlet.*;

public class WebConfiguration implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext servletAppConfiguration = new AnnotationConfigWebApplicationContext();
		servletAppConfiguration.register(ServletConfiguration.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppConfiguration);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);

		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		AnnotationConfigWebApplicationContext rootAppConfiguration = new AnnotationConfigWebApplicationContext();
		rootAppConfiguration.register(RootConfiguration.class);

		ContextLoaderListener listener = new ContextLoaderListener(rootAppConfiguration);
		servletContext.addListener(listener);

		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.addMappingForServletNames(null, false, "dispathcer");
		filter.setInitParameter("encoding", "UTF-8");
	}
}
