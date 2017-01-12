package pl.shop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductCategoryValidator implements ConstraintValidator<ProductCategory, String> {
	@Override
	public void initialize(ProductCategory constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			return true;
		}
		if (value.equalsIgnoreCase("Laptop") || value.equalsIgnoreCase("Tablet")) {
			return true;
		}
		return false;
	}
}
