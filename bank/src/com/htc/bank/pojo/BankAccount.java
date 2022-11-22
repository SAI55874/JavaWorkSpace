package com.htc.bank.pojo;

import java.util.Objects;

public class BankAccount {
	private String accountNo;
	private String accountName;
	private int balance;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public BankAccount() {
		super();
	}
	public BankAccount(String accountNo, String accountName, int balance) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(accountNo, other.accountNo);
	}
	@Override
	public String toString() {
		return " [accountNo=" + accountNo + ", accountName=" + accountName + ", balance=" + balance + "]";
	}
	
}
