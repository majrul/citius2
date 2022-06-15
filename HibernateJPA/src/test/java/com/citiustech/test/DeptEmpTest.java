package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.DeptEmpDao;
import com.citiustech.dao.EmployeeDao;
import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Department;
import com.citiustech.entity.Employee;

public class DeptEmpTest {

	@Test
	public void addDept() {
		Department dept = new Department();
		dept.setName("IT");
		dept.setLocation("Airoli");
		
		GenericDao dao = new GenericDao();
		dao.save(dept);
	}
	
	@Test
	public void addEmp() {
		GenericDao dao = new GenericDao();
		Department dept = dao.findById(Department.class, 1);

		Employee emp = new Employee();
		emp.setName("Jack");
		emp.setSalary(50000);
		emp.setDateOfJoining(LocalDate.of(2020, 3, 10));
		emp.setDepartment(dept);
		dao.save(emp);
	}
	
	@Test
	public void fetchEmp() {
		GenericDao dao = new GenericDao();
		Employee emp = dao.findById(Employee.class, 6);
		System.out.println(emp.getName() + " " + emp.getSalary());
		Department dept = emp.getDepartment();
		System.out.println(dept.getName() + " " + dept.getLocation());
	}
	
	@Test
	public void fetchEmp2() {
		DeptEmpDao dao = new DeptEmpDao();
		Employee emp = dao.fetchEmployeeWithDepartment(6);
		System.out.println(emp.getName() + " " + emp.getSalary());
		Department dept = emp.getDepartment();
		System.out.println(dept.getName() + " " + dept.getLocation());
	}

	@Test
	public void fetchDept() {
		GenericDao dao = new GenericDao();
		Department dept = dao.findById(Department.class, 1);
		System.out.println(dept.getName() + " " + dept.getLocation());
		for(Employee emp : dept.getEmployees())
			System.out.println(emp.getName() + " " + emp.getSalary());			
	}
}
