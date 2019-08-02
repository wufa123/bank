package com.zx.bank.service;

import com.zx.bank.entity.Account;

public interface AccountService {
	
	public Account getAccount(String accountId, String password);
	
	public Account getAccountById(String accountId);

}
