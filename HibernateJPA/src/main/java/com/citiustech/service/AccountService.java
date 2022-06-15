package com.citiustech.service;

import java.time.LocalDateTime;
import java.util.List;

import com.citiustech.dao.AccountTransactionDao;
import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Account;
import com.citiustech.entity.TransactionDetail;

public class AccountService {

	public void openAccount(Account acc) {
		if(acc.getBalance() < 5000)
			throw new RuntimeException("Not enough balance for opening an account!");
		else {
			GenericDao dao = new GenericDao();
			dao.save(acc);
		}
	}
	
	//one record should get inserted in transactiondetail table
	//account table should be updated with the  new balance
	public void withdraw(int accountId, double amount) {
		GenericDao dao = new GenericDao();
		Account account = dao.findById(Account.class, accountId);
		if(amount > account.getBalance())
			throw new RuntimeException("Insufficient Balance!");
		else {
			account.setBalance(account.getBalance() - amount);
			dao.save(account);
			
			TransactionDetail details = new TransactionDetail();
			details.setAccount(account);
			details.setType("Withdraw");
			details.setAmount(amount);
			details.setDateAndTime(LocalDateTime.now());
			dao.save(details);
		}
	}

	public void deposit(int accountId, double amount) {
		GenericDao dao = new GenericDao();
		Account account = dao.findById(Account.class, accountId);
		account.setBalance(account.getBalance() + amount);
		dao.save(account);
			
		TransactionDetail details = new TransactionDetail();
		details.setAccount(account);
		details.setType("Deposit");
		details.setAmount(amount);
		details.setDateAndTime(LocalDateTime.now());
		dao.save(details);
	}

	//as of now our service class is not managing db transactions properly
	//code to begin/commit/rollback should be managed by service, not dao
	public void transfer(int fromAccountId, int toAccountId, double amount) {
		withdraw(fromAccountId, amount);
		deposit(toAccountId, amount);
	}

	public double balanceCheck(int accountId) {
		GenericDao dao = new GenericDao();
		Account account = dao.findById(Account.class, accountId);
		return account.getBalance();
	}

	public List<TransactionDetail> miniStatement(int accountId) {
		AccountTransactionDao dao = new AccountTransactionDao();
		return dao.fetchMiniStatement(accountId);
	}
	
	public List<Account> getAccountsByTransactionCount(int count) {
		AccountTransactionDao dao = new AccountTransactionDao();
		return dao.fetchAccountsByTransactionCount(count);
	}
}
