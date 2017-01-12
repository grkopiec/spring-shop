package pl.shop.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.shop.domain.Product;
//we also have checking image 
public class ProductImageValidation implements Validator {
	private static final Long ALLOWED_SIZE = 1000000L;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if (product.getImage() != null && product.getImage().getSize() > ALLOWED_SIZE) {
			errors.rejectValue("image", "validation.product.image");
		}
	}
}
