package com.meritamerica.assignment6.models;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;



//@Entity
public class CDOffering {
	private static int nextID = 1;
	private int id;
	@Positive(message = "interestRate must be greater than 0.")
	@Max(value = 1, message = "interestRate must be less than 1.")
	private double interestRate;
	@NotBlank(message = "Interest Rate can't be below zero or above one")
	@Min(value = 1, message = "term must be greater than 1.")
	private int term;

	public CDOffering() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param term
	 * @param interestRate
	 */
	public CDOffering(double interestRate, int term) {
		this.id = nextID++;
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
