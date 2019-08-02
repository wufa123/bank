package com.zx.bank.dao;

import com.zx.bank.entity.Account;

public interface AccountDao {

	/**
	 * 根据accountId获取账户信息
	 */
	public Account getAccount(String accountId);
}
