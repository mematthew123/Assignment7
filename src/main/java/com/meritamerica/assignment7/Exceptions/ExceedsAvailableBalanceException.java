package com.meritamerica.assignment7.Exceptions;

public class ExceedsAvailableBalanceException extends Exception {
	ExceedsAvailableBalanceException(String errorMessage){
		super(errorMessage);
	}
}
