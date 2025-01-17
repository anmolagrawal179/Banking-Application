package com.ba.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.entity.Account;
import com.ba.exception.AccountNotFoundException;
import com.ba.exception.InsufficientBalanceException;
import com.ba.repository.AccountRepository;
import com.ba.response.AccountResponse;
import com.ba.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<AccountResponse> getAllAccounts() {

		List<Account> accountList = accountRepository.findAll();
		List<AccountResponse> accountResponseList = accountList.stream()
				.map(account -> modelMapper.map(account, AccountResponse.class)).collect(Collectors.toList());
		return accountResponseList;
	}

	@Override
	public AccountResponse addAccount(AccountResponse accountResponse) {
		Account account = modelMapper.map(accountResponse, Account.class);
		Account savedAcount = accountRepository.save(account);

		return modelMapper.map(savedAcount, AccountResponse.class);
	}

	@Override
	public AccountResponse getAccountById(Long id) {

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
		return modelMapper.map(account, AccountResponse.class);
	}

	@Override
	public AccountResponse deposit(Long id, Double amount) {

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));

		account.setBalance(amount + account.getBalance());

		Account savedAccount = accountRepository.save(account);

		return modelMapper.map(savedAccount, AccountResponse.class);
	}

	@Override
	public AccountResponse withdraw(Long id, Double amount) {

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));

		if (account.getBalance() < amount) {
			throw new InsufficientBalanceException("Insufficient funds");
		}
		account.setBalance(account.getBalance() - amount);

		Account savedAccount = accountRepository.save(account);

		return modelMapper.map(savedAccount, AccountResponse.class);

	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
		accountRepository.delete(account);

	}

	@Override
	public List<AccountResponse> getAccountsByBalanceBetween(Double min, Double max) {

		List<Account> accountList = accountRepository.findByBalanceBetween(min,max);
		List<AccountResponse> accountResponseList = accountList.stream()
				.map(account -> modelMapper.map(account, AccountResponse.class)).collect(Collectors.toList());
		return accountResponseList;
	}

	@Override
	public void deleteAllAccounts() {
		accountRepository.deleteAll();
		
	}

	@Override
	public Long countAccounts() {
		return accountRepository.count();
	}

}
