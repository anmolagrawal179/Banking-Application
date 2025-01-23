package com.ba.service;

import java.util.List;

import com.ba.request.DepositRequest;
import com.ba.request.WithdrawRequest;
import com.ba.response.AccountResponse;

public interface AccountService {

	List<AccountResponse> getAllAccounts();

	AccountResponse addAccount(AccountResponse accountResponse);

	AccountResponse getAccountById(Long id);

	List<AccountResponse> getAccountsByBalanceBetween(Double min, Double max);

	AccountResponse deposit(Long id, DepositRequest depositRequest);

	AccountResponse withdraw(Long id, WithdrawRequest withdrawRequest);

	void deleteAccount(Long id);

	void deleteAllAccounts();

	Long countAccounts();

}
