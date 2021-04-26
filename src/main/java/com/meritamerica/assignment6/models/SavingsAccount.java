package com.meritamerica.assignment6.models;

import javax.persistence.Entity;

//@Entity
public class SavingsAccount extends BankAccount {
	public SavingsAccount() {
	} // Default Constructor

	public SavingsAccount(double balance) {
		super(balance);
	}
}
