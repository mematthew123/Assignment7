package com.meritamerica.assignment5.Exceptions;

public class ExceedsAvailableBalanceException extends Exception {
	ExceedsAvailableBalanceException(String errorMessage){
		super(errorMessage);
	}
}
