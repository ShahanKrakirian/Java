package com.shahan.bankaccount;

import java.util.Random;

public class BankAccount {
	protected String accountNumber;
	protected double checkingBalance = 0.0;
	protected double savingsBalance = 0.0;
	protected static int numberOfAccounts = 0;
	protected static double totalStored = 0.0;
	
	//Constructor
	public BankAccount() {
		accountNumber = randomAccountNumber();
		numberOfAccounts += 1;
	}
	
	private String randomAccountNumber(){
		Random r = new Random();
		String acc = "";
		for (int i=0; i<10; i++) {
			acc = acc + r.nextInt(10);
		}
		return acc;
	}
	
	public void checkAccountBalance() {
		System.out.println("Checking account balance: " + this.checkingBalance);
	}
	
	public void checkSavingsBalance() {
		System.out.println("Savings account balance: " + this.savingsBalance);
	}
	
	public void deposit(String string1, double amount) {
		if (string1 == "Savings" || string1 == "savings") {
			System.out.println("Adding " + amount + " to savings account...");
			this.savingsBalance += amount;
			System.out.println("Total balance: " + this.savingsBalance);
			BankAccount.totalStored += amount;
		}
		else if (string1 == "Checking" || string1 == "checking") {
			System.out.println("Adding " + amount + " to checking account...");
			this.checkingBalance += amount;
			System.out.println("Total balance: " + this.checkingBalance);
			BankAccount.totalStored += amount;
		} else {
			System.out.println("Wrong type of account. Options: Savings, Checking");
		}
	}
	
	public void withdraw(String string1, double amount) {
		if (string1 == "Savings" || string1 == "savings") {
			if (amount > this.savingsBalance) {
				System.out.println("Insufficient funds.");
			} else {
				System.out.println("Withdrawing");
				this.savingsBalance -= amount;
			}
		}
		else if (string1 == "Checking" || string1 == "checking") {
			if (amount > this.checkingBalance) {
				System.out.println("Insufficient funds.");
			} else {
				System.out.println("Withdrawing");
				this.checkingBalance -= amount;
			}
		}
		else {
			System.out.println("Wrong type of account. Options: Savings, Checking");
		}
	}
	
	
	

	
}
