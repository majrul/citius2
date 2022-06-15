package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.EmployeeDao;
import com.citiustech.entity.Employee;

public class EmployeeTest {

	@Test
	public void add() {
		Employee emp = new Employee();
		emp.setName("Amol");
		emp.setSalary(50000);
		emp.setDateOfJoining(LocalDate.of(2022, 3, 10));
		
		EmployeeDao dao = new EmployeeDao();
		int empno = dao.add(emp);
		//System.out.println(empno);
		assertTrue(empno > 0);
		//assert(s) missing
	}

	@Test
	public void fetch() {
		EmployeeDao dao = new EmployeeDao();
		Employee emp = dao.fetch(5);
		
		System.out.println(emp);
		//no println, instead we should assert
		assertNotNull(emp);
	}
}
