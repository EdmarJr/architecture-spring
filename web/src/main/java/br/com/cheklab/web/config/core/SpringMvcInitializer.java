package br.com.cheklab.web.config.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.cheklab.web.config.Config;
import br.com.cheklab.web.config.HibernateListener;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class SpringMvcInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {


	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { Config.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);

		servletContext.addListener(HibernateListener.class);
		servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class)
		.addMappingForUrlPatterns(null, false, "/*");
		servletContext.addFilter("sitemesh", SiteMeshFilter.class)
				.addMappingForUrlPatterns(null, false, "/*");
	}

}