package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
public class EmployeeController {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService eservice;

	/*
	 * @URL: http://localhost:8080/employees
	 */
	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees() {
		LOGGER.info("INSIDE getAllEmployees()");
		ArrayList<Employee> allEmployees = eservice.getAllEmployees();
		return allEmployees;
	}

}
