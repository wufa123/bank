package com.zx.bank.service;

import java.math.BigDecimal;
import java.util.List;

import com.zx.bank.entity.Trade;

public interface TradeService {
	
	public void transferAccount(String receiveAccount, BigDecimal receiveMoney, String fromAccount);
	
	public List<Trade> getTradeList(String startTime, String endTime, String accountId);

}
