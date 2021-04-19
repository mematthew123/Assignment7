package com.meritamerica.assignment5.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.el.parser.ParseException;

public class CheckingAccount extends BankAccount{

	public CheckingAccount() {}
	
	// Constructors
	public CheckingAccount(double balance) {
		super(balance);
		this.interestRate = 0.0001; // 0.01%
	}
	
	  public CheckingAccount(double balance, double interestRate) { super(balance,
	  interestRate); }
	  
	  public CheckingAccount(long accountNumber, double balance, double
	  interestRate) { super(accountNumber, balance, accountNumber); }
	  
	  public CheckingAccount(long accountNumber, double balance, double
	  interestRate, java.util.Date accountOpenedOn) { super(accountNumber, balance,
	  interestRate, accountOpenedOn); }
	 

	// Class methods
	public double getInterestRate() {
		return this.interestRate;
	}

	@Override
	public String toString() {
		return "CheckingAccount [accountBalance=" + accountBalance + ", accountNumber=" + accountNumber
				+ ", interestRate=" + interestRate + ", startDate=" + startDate + "]";
	}
	

}
