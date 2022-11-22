package com.htc.bankMgt.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankM {
	private  List<BankAccounts> bkaccount;

	public  List<BankAccounts> getBkaccount() {
		return bkaccount;
	}

	public void setBkaccount(List<BankAccounts> bkaccount) {
		this.bkaccount = bkaccount;
	}

	public BankM(List<BankAccounts> bkaccount) {
		super();
		this.bkaccount = bkaccount;
	}

	public BankM() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(bkaccount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankM other = (BankM) obj;
		return Objects.equals(bkaccount, other.bkaccount);
	}

	@Override
	public String toString() {
		return "BankM [bkaccount=" + bkaccount + "]";
	}
	
}
