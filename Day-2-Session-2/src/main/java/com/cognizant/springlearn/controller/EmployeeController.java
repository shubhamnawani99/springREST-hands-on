package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService eservice;

	/*
	 * @Note: Get all employee records
	 * 
	 * @URL: http://localhost:8080/employees
	 */
	@GetMapping
	public ArrayList<Employee> getAllEmployees() {
		LOGGER.info("INSIDE getAllEmployees()");
		ArrayList<Employee> allEmployees = eservice.getAllEmployees();
		return allEmployees;
	}

	/*
	 * @Note: Update Employee
	 * 
	 * @URL: http://localhost:8080/employees
	 * 
	 * @Data:{ "id": 1, "name": "Shubham Nawani", "salary": 150000, "permanent":
	 * true, "dateofBirth": "16/02/1999", "department": { "id": 2, "name":
	 * "Marketing" }, "skills": [ { "id": 1, "name": "HTML" }, { "id": 2, "name":
	 * "CSS" }, { "id": 3, "name": "JavaScript" } ] }
	 */
	@PutMapping
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("INSIDE updateEmployee()");
		eservice.updateEmployee(employee);
		LOGGER.info("Update Done");
	}

	/*
	 * Delete Employee by ID
	 * 
	 * @URL: http://localhost:8080/employees/1
	 * 
	 */
	@DeleteMapping(value = "/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		LOGGER.info("INSIDE deleteEmployee()");
		eservice.deleteEmployeeById(id);
		LOGGER.info("Delete Done");
	}

}
