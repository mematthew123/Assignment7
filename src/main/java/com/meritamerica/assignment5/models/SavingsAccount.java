package com.meritamerica.assignment5.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.el.parser.ParseException;

public class SavingsAccount extends BankAccount{
	static private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public SavingsAccount(double balance) {
		super(balance);
		this.interestRate = 0.01;
	}

	public SavingsAccount(double balance, double interestRate) {
		super(balance, interestRate);
	}

	public SavingsAccount(long accountNumber, double balance, double interestRate) {
		super(accountNumber, balance, accountNumber);
	}

	public SavingsAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public static SavingsAccount readFromString(String accountData) throws ParseException, NumberFormatException, java.text.ParseException {
		ArrayList<String> newAccountHolder = new ArrayList<String>(Arrays.asList(accountData.split(",")));
		return new SavingsAccount(Long.parseLong(newAccountHolder.get(0)),
				Double.parseDouble(newAccountHolder.get(1)), Double.parseDouble(newAccountHolder.get(2)),
				formatter.parse(newAccountHolder.get(3)));
	}
}
