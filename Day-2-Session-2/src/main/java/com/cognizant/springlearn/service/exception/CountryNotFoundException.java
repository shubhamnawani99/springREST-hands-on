package com.cognizant.springlearn.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -830813425126968636L;

}
