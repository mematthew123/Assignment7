package com.meritamerica.assignment7.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InterestRateNotInRangeException extends Exception {
	public InterestRateNotInRangeException(String msg) {
		super(msg);
	}
}
