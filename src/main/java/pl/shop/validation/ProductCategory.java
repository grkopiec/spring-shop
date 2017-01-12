package pl.shop.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductCategoryValidator.class)
@Documented
public @interface ProductCategory {
	public String message() default "pl.shop.validation.Category.message";
	public Class<?>[] groups() default{};
	public abstract Class<? extends Payload>[] payload() default{};
	public String value() default "";
}
