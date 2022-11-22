package com.htc.bankMgt.exception;

public class InsuficientFundsException extends Exception{

	public InsuficientFundsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsuficientFundsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InsuficientFundsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InsuficientFundsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InsuficientFundsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InsuficientFundsException []";
	}

}
