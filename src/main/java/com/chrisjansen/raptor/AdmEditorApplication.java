package com.chrisjansen.raptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

@SpringBootApplication
public class AdmEditorApplication  extends SpringBootServletInitializer implements ServletContextAware {

	public static void main(String[] args) {

		SpringApplication.run(AdmEditorApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { AdmEditorApplication.class});
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("primefaces.THEME", "bootstrap");
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		servletContext.setInitParameter("primefaces.TRANSFORM_METADATA", "true");
		//the following sets @NotNull fields required astricks to display in the UI. See:http://forum.primefaces.org/viewtopic.php?f=3&t=38880
		servletContext.setInitParameter("javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL", "true");
	}
}
