package com.citiustech.dao;

import com.citiustech.entity.Employee;

public class DeptEmpDao extends GenericDao {

	public Employee fetchEmployee(int empno) {
		try {
			return entityManagerFactory
				.createEntityManager()
				.createQuery("select emp from Employee emp where emp.empno = :empno", Employee.class)
				.setParameter("empno", empno)
				.getSingleResult();
		}
		finally {
			entityManagerFactory.close();
		}
	}
	
	public Employee fetchEmployeeWithDepartment(int empno) {
		try {
			return entityManagerFactory
				.createEntityManager()
				.createQuery("select emp from Employee emp join fetch emp.department dept where emp.empno = :empno", Employee.class)
				.setParameter("empno", empno)
				.getSingleResult();
		}
		finally {
			entityManagerFactory.close();
		}
	}

}
