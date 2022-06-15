package com.citiustech.test;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.inheritance.v3.BankAccount;
import com.citiustech.entity.inheritance.v3.CreditCard;

public class InheritanceTest {

	@Test
	public void add() {
		BankAccount bankAcc = new BankAccount();
		bankAcc.setName("Majrul Ansari");
		bankAcc.setNumber(1234567890);
		bankAcc.setBankName("ICICI Bank");
		
		CreditCard creditCard = new CreditCard();
		creditCard.setName("Majrul Ansari");
		creditCard.setNumber(45678912345L);
		creditCard.setType("Visa");
		creditCard.setExpiry("12/25");
		
		GenericDao dao = new GenericDao();
		dao.save(bankAcc);
		dao.save(creditCard);
	}
}
