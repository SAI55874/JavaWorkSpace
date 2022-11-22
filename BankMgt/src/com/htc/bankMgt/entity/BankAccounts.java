package com.htc.bankMgt.entity;

import java.util.Objects;

public class BankAccounts {
	private String acoountId;
	private String accountHolderName;
	private Double balanceAmt;
	static int lastAssigedNumber=0;
	public BankAccounts() {
		super();
		
	}
	public String getAcoountId() {
		return acoountId;
	}
	public void setAcoountId(String acoountId) {
		this.acoountId = acoountId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public Double getBalanceAmt() {
		return balanceAmt;
	}
	public void setBalanceAmt(Double balanceAmt) {
		this.balanceAmt = balanceAmt;
		
	}
	@Override
	public String toString() {
		return "BankAccounts [acoountId=" + lastAssigedNumber+ ", accountHolderName=" + accountHolderName + ", balanceAmt="
				+ balanceAmt + "]";
	}
	public BankAccounts(String accountHolderName) {
		super();
		
		this.accountHolderName = accountHolderName;
		this.balanceAmt=1000.00;
		this.lastAssigedNumber++;
	}
	@Override
	public int hashCode() {
		return Objects.hash(acoountId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccounts other = (BankAccounts) obj;
		return Objects.equals(acoountId, other.acoountId);
	}
	
}
