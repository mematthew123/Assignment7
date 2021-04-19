package com.meritamerica.assignment5.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.sun.el.parser.ParseException;

public class CDAccount extends BankAccount{
	private CDOffering offering;
	static private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public CDAccount() {}
	
	public CDOffering getOffering() {
		return offering;
	}

	public void setOffering(CDOffering offering) {
		this.offering = offering;
	}

	// Constructor
	public CDAccount(CDOffering offering, double balance) {
		super(balance);
		this.offering = offering;
	}

	public CDAccount(long accountNumber, double balance, double interestRate, Date startDate, int term) {
		super(accountNumber, balance, interestRate, startDate, term);
		offering = new CDOffering(interestRate, term);

	}

	// Class methods:
	public double getInterestRate() {
		return this.offering.getInterestRate();
	}

	int getTerm() {
		return this.offering.getTerm();
	}

	@Override
	public boolean deposit(double amount) {
		return false;
	}

	@Override
	public boolean withdraw(double amount) {
		return false;
	}

	public double futureValue() {
		return this.getBalance() * (Math.pow(1 + this.getInterestRate(), this.getTerm()));
	}
}
