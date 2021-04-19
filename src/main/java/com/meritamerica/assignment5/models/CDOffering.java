package com.meritamerica.assignment5.models;

import javax.validation.constraints.NotBlank;

public class CDOffering {
	
	private static int nextID = 1;
	private int id;
	@NotBlank(message = "Interest Rate can't be below zero or above one")
	private double interestRate;
	@NotBlank(message = "Term can not be less than 1")
	private int term;

	CDOffering(double interestRate, int term) {
		id = nextID++;
		this.interestRate = interestRate;
		this.term = term;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}


	public String writeToString() {
		String newString = this.interestRate + "," + this.term;
		return newString;
	}
}
