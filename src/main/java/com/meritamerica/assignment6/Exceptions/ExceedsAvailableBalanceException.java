package com.meritamerica.assignment6.Exceptions;

public class ExceedsAvailableBalanceException extends Exception {
	ExceedsAvailableBalanceException(String errorMessage){
		super(errorMessage);
	}
}
