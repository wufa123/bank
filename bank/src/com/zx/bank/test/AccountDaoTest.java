package com.zx.bank.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.zx.bank.dao.AccountDao;
import com.zx.bank.dao.TradeDao;
import com.zx.bank.dao.impl.AccountDaoImpl;
import com.zx.bank.dao.impl.TradeDaoImpl;
import com.zx.bank.entity.Account;
import com.zx.bank.entity.Trade;

public class AccountDaoTest {

	AccountDao accountDao = new AccountDaoImpl();
	
	TradeDao tradeDao = new TradeDaoImpl();
	
	@Test
	public void testGetAccount() {
		Account account = accountDao.getAccount("10010008009");
		System.out.println(account);
	}
	
	@Test
	public void testTradeAccount() {
		tradeDao.transferAccount("10010009009", new BigDecimal(200), "10010008009");
	}
	
	@Test
	public void testTradeList() {
		List<Trade> list = tradeDao.getTradeList("2019-08-01", "2019-08-05", "10010008009");
		for(Trade t : list) {
			System.out.println(t);
		}
	}
}
