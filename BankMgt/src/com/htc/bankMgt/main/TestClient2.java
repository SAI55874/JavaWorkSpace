package com.htc.bankMgt.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.htc.bankMgt.dao.BankMgtDao;
import com.htc.bankMgt.daoImpl.BankMgtDaoImpl;
import com.htc.bankMgt.entity.BankAccounts;
import com.htc.bankMgt.entity.BankM;

public class TestClient2 {
public static void main(String[] args) {
	BankM bank=new BankM();
	BankAccounts bks=new BankAccounts("saikumar");
	List<BankAccounts> banksac=new ArrayList<>();
	banksac.add(bks);
	bank.setBkaccount(banksac);
	BankMgtDao bankac=new BankMgtDaoImpl();
	
//	bankac.createBankAcc("asdsss");
	bankac.createBankAcc(bks);
	
	
	System.out.println(bank.toString());
	System.out.println(bks.toString());
//	Logger log=Logger.getLogger(TestClient2.class.getName());
//	log.severe("");
//	log.info("information"+bank.toString());
//	log.config(bank.toString());
}
}
