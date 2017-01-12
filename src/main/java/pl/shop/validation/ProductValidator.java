package pl.shop.validation;

import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.shop.domain.Product;

public class ProductValidator implements Validator {
	@Autowired
	private javax.validation.Validator validator;
	
	private Collection<Validator> validators;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
		for (ConstraintViolation<Object> constraintViolation: constraintViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, message);
		}
		for (Validator validator: validators) {
			validator.validate(target, errors);
		}
	}
	
	public void setValidators(Collection<Validator> validators) {
		this.validators = validators;
	}
}
