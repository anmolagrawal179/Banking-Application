package com.ba.service;

import java.util.List;

import com.ba.response.AccountResponse;

public interface AccountService {

	List<AccountResponse> getAllAccounts();
	
	AccountResponse addAccount(AccountResponse accountResponse);
	
	AccountResponse getAccountById(Long id);
	
	List<AccountResponse> getAccountsByBalanceBetween(Double min, Double max);
	
	AccountResponse deposit(Long id, Double amount);
	
	AccountResponse withdraw(Long id, Double amount);
	
	void deleteAccount(Long id);
	
	void deleteAllAccounts();
	
	Long countAccounts();
	
	
	
	
}
