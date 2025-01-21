package com.ba.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AccountResponse {

	private Long id;

	@NotBlank
	private String accountHolderName;

	@Positive
	private double balance;
}
