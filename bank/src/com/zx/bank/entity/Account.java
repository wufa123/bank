package com.zx.bank.entity;

import java.math.BigDecimal;

public class Account {
	
	private String accountId;
	
	private String password;
	
	private BigDecimal remaining;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getRemaining() {
		return remaining;
	}

	public void setRemaining(BigDecimal remaining) {
		this.remaining = remaining;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", password=" + password + ", remaining=" + remaining + "]";
	}

}
