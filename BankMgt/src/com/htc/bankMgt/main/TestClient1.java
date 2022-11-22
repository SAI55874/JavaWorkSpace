package com.htc.bankMgt.main;

import java.util.ArrayList;
import java.util.List;

import com.htc.bankMgt.entity.BankAccounts;
import com.htc.bankMgt.entity.BankM;

public class TestClient1 {
	public static void main(String[] args) {
	BankM bk= new BankM();
	List <BankAccounts> bankaccs= new ArrayList<>();
	bankaccs.add(new BankAccounts("saikumar"));
	bankaccs.add(new BankAccounts("sai"));
	System.out.println(bankaccs.toString());
	
	}
}
