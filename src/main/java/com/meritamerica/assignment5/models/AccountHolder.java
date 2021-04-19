package com.meritamerica.assignment5.models;

import java.awt.List;
import java.util.ArrayList;

import javax.validation.constraints.NotBlank;

import com.meritamerica.assignment5.Exceptions.ExceedsCombinedBalanceLimitException;



public class AccountHolder{
	// Constants
	public static final long BALANCE_LIMIT = 250000;


	// Instance variables
	private int id;
	@NotBlank(message = "First Name cannot be blank")
	private String firstName;
	private String middleName;
	@NotBlank(message = "Last Name cannot be blank")
	private String lastName;
	@NotBlank(message = "SSN cannot be blank")
	private String ssn;
	private ArrayList <CheckingAccount> checkingAccounts;
	private ArrayList <SavingsAccount> saveAccounts;
	private ArrayList <CDAccount> cdAccounts;

	private static long nextAccountNumber;
	private static int idGen = 1;
	

	// Constructor
	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.setId();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		checkingAccounts = new ArrayList<CheckingAccount>();
		saveAccounts = new ArrayList<SavingsAccount>();
		cdAccounts = new ArrayList<CDAccount>();
		nextAccountNumber = 1;
	}

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSSN() {
		return ssn;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	public ArrayList<CheckingAccount> getCheckingAccounts() {
		return this.checkingAccounts;
	}

	public void setCheckingAccounts(ArrayList<CheckingAccount> checkAccounts) {
		this.checkingAccounts = checkAccounts;
	}

	public int getNumberOfCheckingAccounts() {
		return this.checkingAccounts.size();
	}

	public double getCheckingBalance() {
		double total = 0;
		for (int i = 0; i < checkingAccounts.size(); i++) {
			total += checkingAccounts.get(i).getBalance();
		}
		return total;
	}

	public ArrayList<SavingsAccount> getSavingsAccounts() {
		return this.saveAccounts;
	}

	public int getNumberOfSavingsAccounts() {
		return this.saveAccounts.size();
	}

	public double getSavingsBalance() {
		double total = 0;

		for (int i = 0; i < saveAccounts.size(); i++) {
			total += saveAccounts.get(i).getBalance();
		}

		return total;
	}

	public void setSavingsAccounts(ArrayList<SavingsAccount> saveAccounts) {
		this.saveAccounts = saveAccounts;
	}

	public ArrayList<CDAccount> getCdAccounts() {
		return this.cdAccounts;
	}

	public int getNumberOfCDAccounts() {
		return this.cdAccounts.size();
	}

	public double getCDBalance() {
		double total = 0;

		for (int i = 0; i < cdAccounts.size(); i++) {
			total += cdAccounts.get(i).getBalance();
		}

		return total;
	}

	public void setCdAccounts(ArrayList<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}

	public double getCombinedBalance() {
		double total = 0;

		for (int i = 0; i < checkingAccounts.size(); i++) {
			total += checkingAccounts.get(i).getBalance();
		}

		for (int i = 0; i < saveAccounts.size(); i++) {
			total += saveAccounts.get(i).getBalance();
		}

		for (int i = 0; i < cdAccounts.size(); i++) {
			total += cdAccounts.get(i).getBalance();
		}

		return total;
	}



	public void addCheckingAccount(CheckingAccount checkingAccount)
			throws ExceedsCombinedBalanceLimitException {
		if (getCombinedBalance() + checkingAccount.getBalance() >= BALANCE_LIMIT) {

			throw new ExceedsCombinedBalanceLimitException(
					"You have reached the maximum total balance across all accounts. Cannot create another.");

		} else {
			checkingAccounts.add(checkingAccount);
		}
	}

	// Add savings account
	public SavingsAccount addSavingsAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException {
		SavingsAccount newSavingsAccount = new SavingsAccount(openingBalance);
		if (getCombinedBalance() + openingBalance >= BALANCE_LIMIT) {

			throw new ExceedsCombinedBalanceLimitException(
					"You have reached the maximum total balance across all accounts. Cannot create another.");

		} else {
			// Add a deposit transaction
			return addSavingsAccount(newSavingsAccount);
		}
	}

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) throws ExceedsCombinedBalanceLimitException {
		if (getCombinedBalance() + savingsAccount.getBalance() >= BALANCE_LIMIT) {
			throw new ExceedsCombinedBalanceLimitException(
					"You have reached the maximum total balance across all accounts. Cannot create another.");

		} else {
			saveAccounts.add(savingsAccount);
			return savingsAccount;
		}
	}

	// Add CD Accounts
	public CDAccount addCDAccount(CDAccount cdAccount) {
		cdAccounts.add(cdAccount);
		return cdAccount;
	}

	public static long getNewAccountNumber() {
		return nextAccountNumber++;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = idGen++;
	}

}
