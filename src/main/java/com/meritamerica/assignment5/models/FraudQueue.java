package com.meritamerica.assignment5.models;

public class FraudQueue {
	private static Transaction fraudTransaction;

	public static void addTransaction(Transaction transaction) {
		fraudTransaction = transaction;
	}

	public Transaction getTransaction() {
		return fraudTransaction;
	}
}
