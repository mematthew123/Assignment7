package com.meritamerica.assignment5.models;

import java.text.SimpleDateFormat;

public class Transaction {
	BankAccount sourceAccount;
	BankAccount targetAccount;
	double amount;
	java.util.Date transactionDate;
	String rejectionReason;
	boolean isProcessed;
	static private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	BankAccount getSourceAccount() {
		return this.sourceAccount;
	}

	public void setSourceAccount(BankAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public BankAccount getTargetAccount() {
		return this.targetAccount;
	}

	public void setTargetAccount(BankAccount targetAccount) {
		this.targetAccount = targetAccount;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.util.Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(java.util.Date date) {
		this.transactionDate = date;
	}

	public String writeToString() {
		return this.sourceAccount + "," + this.targetAccount + "," + this.amount + "," + this.transactionDate;
	}

	public boolean isProcessedByFraudTeam() {
		if (this.isProcessed == true) {
			return true;
		} else {
			return false;
		}
	}

	public void setProcessedByFraudTeam(boolean isProcessed) {
		this.isProcessed = true;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String reason) {
		this.rejectionReason = reason;
	}

}
