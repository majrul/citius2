package com.citiustech.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Account;
import com.citiustech.entity.TransactionDetail;
import com.citiustech.service.AccountService;

public class AccountServiceTest {

	@Test
	public void openAccount() {
		AccountService service = new AccountService();
		
		Account account = new Account();
		account.setName("Smith");
		account.setType("Savings");
		account.setBalance(10000);
		
		service.openAccount(account);
	}
	
	@Test
	public void withdraw() {
		AccountService service = new AccountService();
		service.withdraw(1, 1000);
	}
	
	@Test
	public void deposit() {
		AccountService service = new AccountService();
		service.deposit(2, 5000);
	}
	
	@Test
	public void transfer() {
		AccountService service = new AccountService();
		service.transfer(1, 3, 1000);
	}
	
	@Test
	public void miniStatement() {
		AccountService service = new AccountService();
		List<TransactionDetail> list = service.miniStatement(1);
		list.forEach(System.out::println);
	}
	
	@Test
	public void accountsByTxCount() {
		AccountService service = new AccountService();
		List<Account> list = service.getAccountsByTransactionCount(5);
		list.forEach(System.out::println);
	}
}
