package com.htc.bankMgt.serviceImpl;

import com.htc.bankMgt.dao.BankMgtDao;
import com.htc.bankMgt.daoImpl.BankMgtDaoImpl;
import com.htc.bankMgt.entity.BankAccounts;
import com.htc.bankMgt.service.BankDaoService;

public class BankMgtServiceImpl implements BankDaoService{

	
	BankMgtDao bankac=new BankMgtDaoImpl();
	@Override
	public boolean createBankAcc(BankAccounts bankaccs) {
		// TODO Auto-generated method stub
		return bankac.createBankAcc(bankaccs);
	}

	@Override
	public BankAccounts removeBankAcc(BankAccounts ba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccounts checkBankAccount(BankAccounts ba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getBalance(BankAccounts ba) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean depositMoney(BankAccounts balanceAmt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdrawMoney(BankAccounts account, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferMoney(BankAccounts fromAccountNo, BankAccounts toaccountNo, BankAccounts amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
