package com.htc.bankMgt.service;

import com.htc.bankMgt.entity.BankAccounts;

public interface BankDaoService {
	
		boolean createBankAcc(BankAccounts bankaccs);
		BankAccounts removeBankAcc(BankAccounts ba);
		BankAccounts checkBankAccount(BankAccounts ba);
		double getBalance(BankAccounts ba);
		boolean depositMoney(BankAccounts balanceAmt);
		boolean withdrawMoney(BankAccounts account, double amount);
		boolean transferMoney(BankAccounts fromAccountNo, BankAccounts toaccountNo,BankAccounts amount);
}
