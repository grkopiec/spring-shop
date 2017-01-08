package pl.shop.mvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pl.shop.repository", "pl.shop.services", "pl.shop.configuration", "pl.shop.mvc.interceptors"})
public class RootConfig {
	
}
