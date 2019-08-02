package com.zx.bank.exception;

public class BaseInfoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BaseInfoException() {
		// TODO Auto-generated constructor stub
	}

	public BaseInfoException(String msg) {
		super(msg);
	}

	public BaseInfoException(String msg, Exception ex) {
		super(msg, ex);
	}

}
