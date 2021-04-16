package com.meritamerica.assignment5.Exceptions;

public class ExceedsFraudSuspicionLimitException extends Exception {
	public ExceedsFraudSuspicionLimitException(String errorMessage) {
		super(errorMessage);
	}
}
