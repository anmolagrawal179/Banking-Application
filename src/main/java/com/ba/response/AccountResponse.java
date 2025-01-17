package com.ba.response;

import lombok.Data;

@Data
public class AccountResponse {

	private Long id;
	private String accountHolderName;
	private double balance;
}
