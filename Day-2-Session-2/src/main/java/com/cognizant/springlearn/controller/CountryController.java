package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Day2Session2Application;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(Day2Session2Application.class);

	@Autowired
	private CountryService countryService;

	/*
	 * @URL: http://localhost:8080/countries
	 * 
	 * @Note: Get all countries
	 */
	@SuppressWarnings("unchecked")
	@GetMapping()
	public List<Country> getAllCountries() {
		LOGGER.info("Inside getAllCountries");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		return context.getBean("countryList", ArrayList.class);
	}

	/*
	 * @URL: http://localhost:8080/countries/1
	 * 
	 * @Note: Get Country value from country id using path variable
	 */
	@GetMapping(value = "/{id}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("Inside getCountry");
		return countryService.getCountry(code);
	}

	/*
	 * @URL: http://localhost:8080/countries
	 * 
	 * @Raw: {"code":"IN","name":"India"}
	 * 
	 * @Note: Add a country record. @Valid: This initimates spring framework to
	 * validate the country bean based on the validation annotations added in the
	 * Country class
	 */
	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("Inside addCountry");

		// Create validator factory
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Validation is done against the annotations defined in country bean
		Set<ConstraintViolation<Country>> violations = validator.validate(country);
		List<String> errors = new ArrayList<String>();

		// Accumulate all errors in an ArrayList of type String
		for (ConstraintViolation<Country> violation : violations) {
			errors.add(violation.getMessage());
		}

		// Throw exception so that the user of this web service receives appropriate
		// error message
		if (violations.size() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
		}

		LOGGER.info(country.toString());
		return countryService.addCountry(country);
	}

	/*
	 * @URL: http://localhost:8080/countries/1
	 * 
	 * @Note: Delete a country record
	 */
	@DeleteMapping(value = "{/id}")
	public void deleteCountry() {

	}

	/*
	 * @URL: http://localhost:8080/countries/1
	 * 
	 * @Note: Update a country record
	 */
	@PutMapping
	public void updateCountry() {

	}
}
