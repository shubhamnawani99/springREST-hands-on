package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.service.DepartmentService;

@RestController
public class DepartmentController {

	private final static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService dservice;

	/*
	 * @URL: http://localhost:8080/department
	 */
	@GetMapping("/department")
	public ArrayList<Department> getAllDepartments() {
		LOGGER.info("INSIDE getAllDepartments()");
		ArrayList<Department> allDepartments = dservice.getAllDepartments();
		return allDepartments;
	}

}
