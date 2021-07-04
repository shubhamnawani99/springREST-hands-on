package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;

@Service
public class DepartmentService {

	private DepartmentDao departmentDao = new DepartmentDao();

	public ArrayList<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}
}
