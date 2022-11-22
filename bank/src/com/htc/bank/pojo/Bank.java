package com.htc.bank.pojo;

import java.lang.reflect.Array;
import java.util.Arrays;


public class Bank {
	private BankAccount[] bankaccounts;

	@Override
	public String toString() {
		return "Bank" + Arrays.toString(bankaccounts);
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(BankAccount[] bank) {
		super();
		this.bankaccounts = bank;
	}

	public BankAccount[] getBank() {
		return bankaccounts;
	}

	public void setBank(BankAccount[] bank) {
		this.bankaccounts = bank;
	}
	

	
}
