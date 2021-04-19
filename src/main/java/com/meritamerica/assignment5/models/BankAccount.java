package com.meritamerica.assignment5.models;

import java.time.LocalDateTime;
import java.util.Date;

public class BankAccount {
	public double accountBalance;
	public long accountNumber;
	public double interestRate;
	public Date startDate;

	public BankAccount() {}
	// Constructors
	public BankAccount(double balance) {
		this.accountBalance = balance;
		this.accountNumber = AccountHolder.getNewAccountNumber();
		//this.startDate = LocalDateTime.now();
	}

	public BankAccount(double balance, double interestRate) {
		this.accountBalance = balance;
		this.interestRate = interestRate;
		this.accountNumber = AccountHolder.getNewAccountNumber();
	}

	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.accountBalance = balance;
		this.interestRate = interestRate;
	}

	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		this.accountNumber = accountNumber;
		this.accountBalance = balance;
		this.interestRate = interestRate;
		this.startDate = accountOpenedOn;
	}

	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn,
			int term) {
		this.accountNumber = accountNumber;
		this.accountBalance = balance;
		this.interestRate = interestRate;
		this.startDate = accountOpenedOn;

	}

	// Getters
	public long getAccountNumber() {
		return this.accountNumber;
	}

	public double getBalance() {
		return this.accountBalance;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	// Account methods
	public boolean withdraw(double amount) {
		if (amount <= this.accountBalance) {
			this.accountBalance -= amount;
			return true;
		} else {
			return false;
		}
	}

	public boolean deposit(double amount) {
		if (amount <= 0) {
			return false;
		} else {
			this.accountBalance += amount;
			return true;
		}
	}

	// Get opening date
	Date getOpenedOn() {
		return startDate;
	}

	public double futureValue(int years) {
		return getBalance() * (Math.pow(1 + getInterestRate(), years));
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public double truncateValue(double toTruncate) {
		toTruncate *= 100;
		int truncatedInt = (int) toTruncate;
		double truncatedDouble = (double) truncatedInt / 100;
		return truncatedDouble;
	}

	public String toString() {

		return "Account Balance: $" + getBalance() + "\n" + "Account Interest Rate: 0.0001\n"
				+ "Account Balance in 3 years: $" + truncateValue(futureValue(3));
	}

}
