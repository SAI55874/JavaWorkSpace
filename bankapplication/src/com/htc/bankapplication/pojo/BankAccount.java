package com.htc.bankapplication.pojo;

import java.util.Objects;

public class BankAccount {
	private int accountid;
	private String hoderName;
	private double balance;
	private static int lastAssignednumber=0;
	public BankAccount() {
		super();
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getHoderName() {
		return hoderName;
	}
	public void setHoderName(String hoderName) {
		this.hoderName = hoderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public BankAccount(String hoderName) {
		super();
		lastAssignednumber++;
		this.accountid=lastAssignednumber;
		this.hoderName = hoderName;
		this.balance=1000.00;
	}
	@Override
	public String toString() {
		return "BankAccount [accountid=" + accountid + ", hoderName=" + hoderName + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountid);
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
		return accountid == other.accountid;
	}
	

}
