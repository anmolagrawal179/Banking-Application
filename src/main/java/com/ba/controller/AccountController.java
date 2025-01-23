package com.ba.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ba.request.DepositRequest;
import com.ba.request.WithdrawRequest;
import com.ba.response.AccountResponse;
import com.ba.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping
	public ResponseEntity<AccountResponse> addAccount(@RequestBody @Valid AccountResponse accountResponse) {
		return new ResponseEntity<AccountResponse>(accountService.addAccount(accountResponse), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<AccountResponse>> getAllAccounts() {
		return new ResponseEntity<List<AccountResponse>>(accountService.getAllAccounts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountResponse> getAccountById(@PathVariable Long id) {
		return new ResponseEntity<AccountResponse>(accountService.getAccountById(id), HttpStatus.OK);
	}

	@PutMapping("/deposit/{id}")
	public ResponseEntity<AccountResponse> deposit(@PathVariable Long id,
			@RequestBody @Valid DepositRequest depositRequest) {
		return new ResponseEntity<AccountResponse>(accountService.deposit(id, depositRequest), HttpStatus.OK);
	}

	@PutMapping("/withdraw/{id}")
	public ResponseEntity<AccountResponse> withdraw(@PathVariable Long id,
			@RequestBody @Valid WithdrawRequest withdrawRequest) {
		return new ResponseEntity<AccountResponse>(accountService.withdraw(id, withdrawRequest), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public String deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);

		return "Account deleted successfully";
	}

	@GetMapping("/range")
	public List<AccountResponse> getAccountsByBalanceBetween(@RequestParam Double min, @RequestParam Double max) {
		return accountService.getAccountsByBalanceBetween(min, max);
	}

	@DeleteMapping
	public String deleteAllAccounts() {
		accountService.deleteAllAccounts();

		return "All accounts get deleted successfully";
	}

	@GetMapping("/count")
	public String countAccounts() {

		return "Total no. of accounts are " + accountService.countAccounts();
	}

}
