package com.zx.bank.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {
	
	private int id;
	
	private String accountId;
	
	private String tradeType;
	
	private BigDecimal tradeMoney;
	
	private Date tradeTime;
	
	private String tradeDigest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeDigest() {
		return tradeDigest;
	}

	public void setTradeDigest(String tradeDigest) {
		this.tradeDigest = tradeDigest;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", accountId=" + accountId + ", tradeType=" + tradeType + ", tradeMoney="
				+ tradeMoney + ", tradeTime=" + tradeTime + ", tradeDigest=" + tradeDigest + "]";
	}

}
