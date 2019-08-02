package com.zx.bank.dao;

import java.math.BigDecimal;
import java.util.List;

import com.zx.bank.entity.Trade;

public interface TradeDao {
	
	public void transferAccount(String receiveAccount, BigDecimal receiveMoney, String fromAccount);

	public List<Trade> getTradeList(String startTime, String endTime, String accountId);
}
