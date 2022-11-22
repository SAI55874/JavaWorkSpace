package com.htc.bankapplication.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
   List<BankAccount> account=new ArrayList<BankAccount>();

public Bank() {
	super();
}

public List<BankAccount> getAccount() {
	return account;
}

public void setAccount(List<BankAccount> account) {
	this.account = account;
}

public Bank(List<BankAccount> account) {
	super();
	this.account = account;
}

@Override
public String toString() {
	return "Bank [account=" + account + "]";
}

@Override
public int hashCode() {
	return Objects.hash(account);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Bank other = (Bank) obj;
	return Objects.equals(account, other.account);
}

   
   
   
   

   
}
