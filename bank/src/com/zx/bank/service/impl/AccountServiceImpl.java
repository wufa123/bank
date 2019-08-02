package com.zx.bank.service.impl;

import com.zx.bank.dao.AccountDao;
import com.zx.bank.dao.impl.AccountDaoImpl;
import com.zx.bank.entity.Account;
import com.zx.bank.exception.BaseInfoException;
import com.zx.bank.service.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountDao = new AccountDaoImpl();

	@Override
	public Account getAccount(String accountId, String password) {
		// TODO Auto-generated method stub
		Account account = accountDao.getAccount(accountId);
		if(account == null) {
			throw new BaseInfoException("您查询的账户不存在");
		}
		if(!(account.getPassword().equals(password))) {
			throw new BaseInfoException("您输入的密码有误");
		}
		return account;
	}

	@Override
	public Account getAccountById(String accountId) {
		// TODO Auto-generated method stub
		Account account = accountDao.getAccount(accountId);
		return account;
	}

}
