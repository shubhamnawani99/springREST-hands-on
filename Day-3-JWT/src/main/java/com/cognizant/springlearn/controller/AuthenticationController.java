package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author Shubham Nawani
 *
 */
@RestController
public class AuthenticationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	private final static String SECRET_KEY = "secretkey";

	/*
	 * Get user from authHeader
	 */
	private String getUser(String authHeader) {
		LOGGER.info("Start");
		String encodedCredentials = authHeader.split(" ")[1];
		byte[] decode = Base64.getDecoder().decode(encodedCredentials);
		String userpass = new String(decode);
		String user = userpass.split(":")[0];
		LOGGER.debug("Username: " + user);
		LOGGER.info("End");
		return user;
	}

	/*
	 * Generate the JSON Web Token
	 */
	private String generateJwt(String user) {

		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date(System.currentTimeMillis()));

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2)));
		builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY);

		String token = builder.compact();

		return token;
	}

	/*
	 * Testing authentication
	 * 
	 * @URL: http://localhost:8080/authenticate
	 */
	@GetMapping(value = "/authenticate")
	public Map<String, String> authenticateUser(@RequestHeader("Authorization") String authHeader) {

		LOGGER.info("Start");

		// Get user from the header
		String user = getUser(authHeader);

		// Generate JWT for the user
		String jwtToken = generateJwt(user);

		// debug log for displaying the authHeader parameter
		LOGGER.debug(authHeader);

		// Create a new HashMap<String, String> and assign it to a map
		Map<String, String> map = new HashMap<>();

		// Put a new item into the map with key as "token" and value as JWT token
		map.put("token", jwtToken);

		LOGGER.info("End");
		return map;
	}

}
