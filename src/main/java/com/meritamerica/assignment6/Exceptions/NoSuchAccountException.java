package com.meritamerica.assignment6.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchAccountException extends Exception {
	public NoSuchAccountException(String msg) {
		super(msg);
	}
}
