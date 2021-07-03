package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Employee;

/*
 * Employee list operations
 */
public class EmployeeDao {

	private static ArrayList<Employee> EMPLOYEE_LIST;

	@SuppressWarnings("unchecked")
	public EmployeeDao() {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
	}

	public ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}
}
