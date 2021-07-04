package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {

	private EmployeeDao employeeDao = new EmployeeDao();

	/*
	 * Get all employees
	 */
	public ArrayList<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	/*
	 * Update employee details
	 */
	public void updateEmployee(Employee emp) {
		employeeDao.updateEmployee(emp);
		return;
	}

	/*
	 * Delete employee record by ID
	 */
	public void deleteEmployeeById(int eid) {
		employeeDao.deleteEmployeeById(eid);
		return;
	}
}
