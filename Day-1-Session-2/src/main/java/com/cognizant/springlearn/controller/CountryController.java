package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.Day1Session2Application;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(Day1Session2Application.class);

	@Autowired
	private CountryService countryService;

	/*
	 * @URL: http://localhost:8080/country
	 * 
	 * @Note: produces -> used define the type of the returned output here we are
	 * converting Country object to JSON
	 */
	@GetMapping(produces = { "application/json" }, value = "/country")
	public Country getCountryIndia() {
		LOGGER.info("Inside getCountryIndia");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		return context.getBean("in", Country.class);
	}

	/*
	 * @URL: http://localhost:8080/countries
	 * 
	 * @Note: Spring Boot does the conversion automatically, hence no need for
	 * "produces" attribute to be used in GetMapping
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("Inside getAllCountries");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		return context.getBean("countryList", ArrayList.class);
	}

	/*
	 * @URL: http://localhost:8080/country/IN
	 * 
	 * @Note: Get Country value from country code using path variable
	 */
	@GetMapping(value = "/country/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("Inside getCountry");
		return countryService.getCountry(code);
	}
}
