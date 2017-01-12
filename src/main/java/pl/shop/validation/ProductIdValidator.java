package pl.shop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import pl.shop.domain.Product;
import pl.shop.services.ProductService;

public class ProductIdValidator implements ConstraintValidator<ProductId, Long> {
	@Autowired
	private ProductService productService;
	
	@Override
	public void initialize(ProductId constraintAnnotation) {
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Product product;
		if (value == null) {	//if value equals null accept
			return true;
		}
		try {
			product = productService.findById(Long.valueOf(value));
		} catch (IllegalArgumentException e) {
			return true;
		}
		if (product != null) {
			return false;
		}
		return true;
	}
}
