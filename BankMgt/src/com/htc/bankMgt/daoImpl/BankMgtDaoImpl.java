package com.htc.bankMgt.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.htc.bankMgt.dao.BankMgtDao;
import com.htc.bankMgt.entity.BankAccounts;
import com.htc.bankMgt.entity.BankM;



public class BankMgtDaoImpl implements BankMgtDao {
	Map<String, BankAccounts> map=new HashMap<>();
	List<BankAccounts> bankaccounts=new ArrayList<>();
	public BankMgtDaoImpl() {
		bankaccounts.add(new BankAccounts("sai"));
	}
	
	public boolean createBankAcc(BankAccounts bankaccs) {
		boolean flag=false;
		bankaccounts.add(bankaccs);
			flag=true;
			return flag;
			}

	
	
	@Override
	public BankAccounts removeBankAcc(BankAccounts ba) {
		boolean flag = false;
        BankAccounts b = map.get(ba);
        if(b!=null) {
        
        flag = map.remove(ba,b);
        
        }
		return b;
        
		
		
	}

	@Override
	public BankAccounts checkBankAccount(BankAccounts ba) {
		
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

	

	

	

//@Override
//public boolean createBankAcc(BankAccounts bankaccs) {
//	boolean flag=false;
//	bankaccounts.add(bankaccs);
//		flag=true;
//		return flag;
//}
//
//@Override
//public boolean createBankAcc(List<BankAccounts> bankaccs) {
//	// TODO Auto-generated method stub
//	return false;
//}

	
}
