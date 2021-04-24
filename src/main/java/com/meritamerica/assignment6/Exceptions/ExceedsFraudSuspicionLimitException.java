package com.meritamerica.assignment6.Exceptions;

public class ExceedsFraudSuspicionLimitException extends Exception {
	public ExceedsFraudSuspicionLimitException(String errorMessage) {
		super(errorMessage);
	}
}
