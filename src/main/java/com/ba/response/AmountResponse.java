package com.ba.response;

import jakarta.validation.constraints.Positive;

public class AmountResponse {
	
	@Positive
	private Double amount ;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
}
