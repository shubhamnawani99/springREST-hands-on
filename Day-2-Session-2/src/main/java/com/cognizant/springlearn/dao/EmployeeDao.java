package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

/*
 * Employee list operations
 */
public class EmployeeDao {

	private static ArrayList<Employee> EMPLOYEE_LIST;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	@SuppressWarnings("unchecked")
	public EmployeeDao() {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
	}

	/*
	 * Get all employees
	 */
	public ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	/*
	 * Update Employee Details
	 */
	public void updateEmployee(Employee emp) {
		LOGGER.info("Before Update :" + EMPLOYEE_LIST.toString());
		int id = emp.getId();
		for (Employee employee : EMPLOYEE_LIST) {
			if (employee.getId() == id) {
				int idx = EMPLOYEE_LIST.indexOf(employee);
				EMPLOYEE_LIST.remove(idx);
				EMPLOYEE_LIST.add(idx, emp);
				LOGGER.info("After Update :" + EMPLOYEE_LIST.toString());
				return;
			}
		}

		throw new EmployeeNotFoundException();
	}

	/*
	 * Delete Employee Record by ID
	 */
	public void deleteEmployeeById(int eid) {
		LOGGER.info("Before Delete :" + EMPLOYEE_LIST.toString());
		for (Employee employee : EMPLOYEE_LIST) {
			if (employee.getId() == eid) {
				EMPLOYEE_LIST.remove(employee);
				LOGGER.info("After Delete :" + EMPLOYEE_LIST.toString());
				return;
			}
		}
		throw new EmployeeNotFoundException();
	}
}
