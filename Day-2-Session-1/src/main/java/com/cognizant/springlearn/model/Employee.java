package com.cognizant.springlearn.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int id;
	private String name;
	private int salary;
	private boolean permanent;
	private Date dateofBirth;
	private Department department;
	private ArrayList<Skill> skills;

	public Employee() {
	}

	public Employee(int id, String name, int salary, boolean permanent, Date dateofBirth, Department department,
			ArrayList<Skill> skills) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateofBirth = dateofBirth;
		this.department = department;
		this.skills = skills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateofBirth=" + dateofBirth + ", department=" + department + ", skills=" + skills + "]";
	}

}
