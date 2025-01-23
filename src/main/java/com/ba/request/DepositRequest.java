package com.ba.request;

import jakarta.validation.constraints.Positive;

public class DepositRequest {

	@Positive
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
