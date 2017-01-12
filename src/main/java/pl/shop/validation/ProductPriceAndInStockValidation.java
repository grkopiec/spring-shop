package pl.shop.validation;

import java.math.BigDecimal;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.shop.domain.Product;

public class ProductPriceAndInStockValidation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if (product.getPrice() != null && new BigDecimal(10000).compareTo(product.getPrice()) <= 0 && product.getInStock() > 99) {
			errors.rejectValue("inStock", "validation.product.priceAndInStack");
		}
	}
}
