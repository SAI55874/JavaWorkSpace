package com.htc.bankMgt.dao;

import java.util.List;

import com.htc.bankMgt.entity.BankAccounts;
import com.htc.bankMgt.entity.BankM;

public interface BankMgtDao {
boolean createBankAcc(BankAccounts bankaccs);
BankAccounts removeBankAcc(BankAccounts ba);
BankAccounts checkBankAccount(BankAccounts ba);
double getBalance(BankAccounts ba);
boolean depositMoney(BankAccounts balanceAmt);
boolean withdrawMoney(BankAccounts account, double amount);
boolean transferMoney(BankAccounts fromAccountNo, BankAccounts toaccountNo,BankAccounts amount);

}
