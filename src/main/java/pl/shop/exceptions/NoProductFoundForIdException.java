package pl.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No product for requested product id")
public class NoProductFoundForIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
