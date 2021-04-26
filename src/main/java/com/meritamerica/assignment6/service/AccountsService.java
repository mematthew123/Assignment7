package com.meritamerica.assignment6.service;

import com.meritamerica.assignment6.Exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment6.Exceptions.InvalidArgumentException;
import com.meritamerica.assignment6.Exceptions.NoSuchAccountException;
import com.meritamerica.assignment6.models.CDAccount;
import com.meritamerica.assignment6.models.CheckingAccount;
import com.meritamerica.assignment6.models.SavingsAccount;

public interface AccountsService {

	public CheckingAccount addCheckingAccount(int id, CheckingAccount checkingAccount) 
			throws NoSuchAccountException, 
			ExceedsCombinedBalanceLimitException, 
			InvalidArgumentException;
	
	public SavingsAccount addSavingsAccount(int id, SavingsAccount savingsAccount) 
			throws NoSuchAccountException, 
			ExceedsCombinedBalanceLimitException, 
			InvalidArgumentException;

	public CDAccount addCDAccount(int id, CDAccount cdAccount) 
			throws NoSuchAccountException, 
			ExceedsCombinedBalanceLimitException, 
			InvalidArgumentException;
}