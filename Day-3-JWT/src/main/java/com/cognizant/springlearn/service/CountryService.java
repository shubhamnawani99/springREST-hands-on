package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@SuppressWarnings("unchecked")
	public Country getCountry(String code) throws CountryNotFoundException {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = context.getBean("countryList", ArrayList.class);

		for (Country country : countries) {
			if (code.equalsIgnoreCase(country.getCode())) {
				return country;
			}
		}
		throw new CountryNotFoundException();
	}

	public Country addCountry(Country country) {
		return country;
	}
}
