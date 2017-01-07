package pl.shop.mvc.configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(System.getProperty("java.io.tempdir"), 1048576, 1048576, 0);
		registration.setMultipartConfig(multipartConfigElement);
	}
}
