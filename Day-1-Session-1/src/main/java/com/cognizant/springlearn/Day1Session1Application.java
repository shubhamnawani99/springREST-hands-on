package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Day1Session1Application {

	// Hands-on-3: Incorporate Logging
	private static final Logger LOGGER = LoggerFactory.getLogger(Day1Session1Application.class);

	// Hands-on-2: Display Date
	@SuppressWarnings("unused")
	private static void displayDate() {
		LOGGER.info("START");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug(date.toString());
		} catch (ParseException e) {
			LOGGER.error("Parse Error");
		}
		LOGGER.info("END");
	}

	// Hands-on-4: Display country by reading data from country.xml
	@SuppressWarnings("unused")
	private static void displayCountry() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country);
		LOGGER.debug("Country : {}", anotherCountry);
	}

	private static void displayCountries() {
		LOGGER.info("START");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<String> countryList = context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Country List: {}", countryList);
		LOGGER.info("END");

	}

	public static void main(String[] args) {
		SpringApplication.run(Day1Session1Application.class, args);
		// displayDate();
		// displayCountry();
		displayCountries();
	}

}
