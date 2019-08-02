package com.zx.bank.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.zx.bank.dao.AccountDao;
import com.zx.bank.dao.TradeDao;
import com.zx.bank.dao.impl.AccountDaoImpl;
import com.zx.bank.dao.impl.TradeDaoImpl;
import com.zx.bank.entity.Account;
import com.zx.bank.entity.Trade;
import com.zx.bank.exception.BaseInfoException;
import com.zx.bank.service.TradeService;

public class TradeServiceImpl implements TradeService {
	
	private AccountDao accountDao = new AccountDaoImpl();
	
	private TradeDao tradeDao = new TradeDaoImpl();

	@Override
	public void transferAccount(String receiveAccount, BigDecimal receiveMoney, String fromAccount) {
		// TODO Auto-generated method stub
		
		Account ra = accountDao.getAccount(receiveAccount);
		if(ra == null) {
			throw new BaseInfoException("接收账号不正确！");
		}
		
		if(receiveAccount.equals(fromAccount)) {
			throw new BaseInfoException("自己不能转账给自己！");
		}
		
		Account fa = accountDao.getAccount(fromAccount);
		
		if(fa.getRemaining().compareTo(receiveMoney) == -1) {
			throw new BaseInfoException("转出账号存款金额不足！");
		}
		
		tradeDao.transferAccount(receiveAccount, receiveMoney, fromAccount);
	}

	@Override
	public List<Trade> getTradeList(String startTime, String endTime, String accountId) {
		// TODO Auto-generated method stub
		return tradeDao.getTradeList(startTime, endTime, accountId);
	}

}
