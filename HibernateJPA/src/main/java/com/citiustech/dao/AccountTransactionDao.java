package com.citiustech.dao;

import java.util.List;

import com.citiustech.entity.Account;
import com.citiustech.entity.TransactionDetail;

public class AccountTransactionDao extends GenericDao {

	public List<TransactionDetail> fetchMiniStatement(int accountId) {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select t from TransactionDetail t where t.account.id = :id order by t.dateAndTime desc", TransactionDetail.class)
				.setParameter("id", accountId)
				.setMaxResults(5)
				.getResultList();
	}
	
	public List<Account> fetchAccountsByTransactionCount(int count) {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select a from Account a where a.transactionDetails.size >= :count", Account.class)
				.setParameter("count", count)
				.getResultList();		
	}
}
