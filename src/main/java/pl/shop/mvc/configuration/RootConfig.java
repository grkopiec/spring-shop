package pl.shop.mvc.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import pl.shop.validation.ProductImageValidation;
import pl.shop.validation.ProductPriceAndInStockValidation;
import pl.shop.validation.ProductValidator;

@Configuration
@ComponentScan(basePackages = {"pl.shop.repository", "pl.shop.services", "pl.shop.configuration", "pl.shop.mvc.interceptors", "pl.shop.validation"})
public class RootConfig {
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
	
	@Bean
	public ProductValidator productValidator() {
		List<Validator> validators = new ArrayList<>();
		validators.add(new ProductPriceAndInStockValidation());
		validators.add(new ProductImageValidation());
		
		ProductValidator productValidator = new ProductValidator();
		productValidator.setValidators(validators);
		return productValidator;
	}
}
