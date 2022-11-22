package com.htc.bankapplication.dao;

import java.util.List;

import com.htc.bankapplication.pojo.BankAccount;

public interface BankAccountDao {

   public List<BankAccount> getAllBankAccounts();
   BankAccount checkAccount(int accountid);
   double getBalance(BankAccount account);
   boolean depositeMoney(BankAccount account, double amount);
   boolean withdrawMoney(BankAccount account, double amount);
   
}
