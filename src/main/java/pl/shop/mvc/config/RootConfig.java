package pl.shop.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pl.shop.repository", "pl.shop.services"})
public class RootConfig {
}
