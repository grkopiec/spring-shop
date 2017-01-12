package pl.shop.mvc.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

import pl.shop.mvc.interceptors.AuditingInterceptor;
import pl.shop.mvc.interceptors.PerformanceInterceptor;
import pl.shop.mvc.interceptors.PromoCodeInterceptor;

@EnableWebMvc	//<mvc:annotation-driven /> enable spring annotation
@Configuration
@ComponentScan(basePackages = "pl.shop.mvc.controllers")	//load controller "AppController.java"
public class WebConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private PerformanceInterceptor performanceInterceptor;
	@Autowired
	private AuditingInterceptor auditingInterceptor;
	@Autowired
	LocalValidatorFactoryBean localValidatorFactoryBean;
	
	@Override	//for resources location, resources for css, js
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

/*	@Override	//static resources
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}*/
	
	@Bean
	public ViewResolver html() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	//allow on proper working annotations "@MatrixVariable" in controllers (this annotation get array variables from URL)
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
//	@Bean
//	public MultipartResolver multipartResolver() {	//we can use apache to sending file
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setMaxUploadSize(1048576);	//1 megabyt limit
//		return multipartResolver;
//	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
//    @Bean	//keep locale in cookies
//    public LocaleResolver localeResolver(){	//if we select any language then this bean save it for session 
//		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		resolver.setDefaultLocale(new Locale("en"));	//default language
//		resolver.setCookieName("myLocaleCookie");	//language cookie name
//		resolver.setCookieMaxAge(4800);	//date of expire language in cookie
//		return resolver;
//    }
	
	@Bean	//keep locale in session
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        return interceptor;
	}
	
	@Bean
	public PromoCodeInterceptor promoInterceptor() {
		PromoCodeInterceptor promoInterceptor = new PromoCodeInterceptor();
		promoInterceptor.setPromoCode("ABCD");
		promoInterceptor.setOfferRedirect("/products/product");
		promoInterceptor.setErrorRedirect("/products/invalidCode");
		return promoInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(performanceInterceptor);
		registry.addInterceptor(localeInterceptor());
		registry.addInterceptor(auditingInterceptor);
		registry.addInterceptor(promoInterceptor());
	}
	
	@Override
	public Validator getValidator() {
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
}
