package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Department;

/*
 * Department list operations
 */
public class DepartmentDao {

	private static ArrayList<Department> DEPARTMENT_LIST;

	@SuppressWarnings("unchecked")
	public DepartmentDao() {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = context.getBean("departmentList", ArrayList.class);
	}

	public ArrayList<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
}
