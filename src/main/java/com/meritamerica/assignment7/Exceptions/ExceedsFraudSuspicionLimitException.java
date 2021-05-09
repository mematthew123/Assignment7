package com.meritamerica.assignment7.Exceptions;

public class ExceedsFraudSuspicionLimitException extends Exception {
	public ExceedsFraudSuspicionLimitException(String errorMessage) {
		super(errorMessage);
	}
}
