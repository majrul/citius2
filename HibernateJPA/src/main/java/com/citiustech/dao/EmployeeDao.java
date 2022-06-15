package com.citiustech.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.citiustech.entity.Employee;

public class EmployeeDao {

	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-demo");
		Runtime.getRuntime().addShutdownHook(new Thread(() -> entityManagerFactory.close()));
	}
	
	public int add(Employee emp) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			
			entityManager.persist(emp); //persist generates insert query
			
			//entityManager.flush();
			tx.commit();
			
			return emp.getEmpno();
		}
		finally {
			entityManager.close();
		}
	}

	public int update(Employee emp) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			
			entityManager.merge(emp); //merge generates update query
			
			//entityManager.flush();
			tx.commit();
			
			return emp.getEmpno();
		}
		finally {
			entityManager.close();
		}
	}

	public Employee fetch(int empno) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			//find generates select query where pk_col = ?
			Employee emp = entityManager.find(Employee.class, empno);
			return emp;
		}
		finally {
			entityManager.close();
		}
		
	}
}
