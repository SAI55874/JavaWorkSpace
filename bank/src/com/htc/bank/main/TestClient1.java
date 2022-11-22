package com.htc.bank.main;

import java.util.Scanner;

import com.htc.bank.pojo.Bank;
import com.htc.bank.pojo.BankAccount;

public class TestClient1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bk =new Bank();
//		bk.bank[0]=new BankAccount("21212","sai","1000");
//		bk.bank[1]=new BankAccount("21213","saik","1000");
		
		
		BankAccount[] bankas=new BankAccount[3];
		bankas[0]=new BankAccount("21212","sai",1000);
		bankas[1]=new BankAccount("21213","saik",1100);
		bankas[2]=new BankAccount("21214","Harish",1200);
		bk.setBank(bankas);
//		BankAccount[] bankas1=bk.getBank();
		System.out.println(bk.toString());
		
		String no=sc.next();
		for(int i=0;i<bankas.length;i++) {
			
			if(bankas[i].getAccountNo().equals(no)) {
				System.out.println(bankas[i].getBalance());
			}
		}
		
		
	}
}
