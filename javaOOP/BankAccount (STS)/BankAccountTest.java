package com.shahan.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount bA1 = new BankAccount();
		BankAccount bA2 = new BankAccount();
		
		System.out.println(bA1.accountNumber);
		System.out.println(bA2.accountNumber);
		System.out.println(BankAccount.numberOfAccounts);
		
		bA1.deposit("Checking", 100);
		bA2.deposit("Savings", 20);
		
		System.out.println(BankAccount.totalStored);
		
		bA1.withdraw("Checking", 110);
		bA1.withdraw("Checking", 90);
		bA1.withdraw("Checkings", 10);
	}


}
