package com.meritamerica.assignment5.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.meritamerica.assignment5.Exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.models.CDOffering;
import com.meritamerica.assignment5.models.CheckingAccount;

@Service
public class MeritBank {
	private static List<AccountHolder> accountHolders;
	private List <CDOffering> cdOfferings;
	
	public MeritBank() {
		this.accountHolders = new ArrayList<AccountHolder>();
		this.cdOfferings = new ArrayList<CDOffering>();
		//Load accounts from file
	}
	
	//Add Account Holder
	public AccountHolder getAccountHolder(int id) {
		AccountHolder accountHolder = null;
		for(AccountHolder accholder: accountHolders) {
			if(accholder.getId()==id) {
				accountHolder = accholder;
			}
		}
		return accountHolder;
	}
	
	//Get CDOffering
		public CDOffering getCDOffering(int id) {
			CDOffering cdOffering = null;
			for(CDOffering cdoffering: cdOfferings) {
				if(cdoffering.getId()==id) {
					cdOffering = cdoffering;
				}
			}
			return cdOffering;
		}
	
	public List<AccountHolder> getAccountHolders() {
		return accountHolders;
	}
	
	public String addAccountHolder(AccountHolder accountHolder) {
		accountHolders.add(accountHolder);
		return "Account added";
	}
	
	
	//Get CD Offerings
	public List<CDOffering> getCDOfferings() {
		return cdOfferings;
	}
	
	public void setCDOfferings(List<CDOffering> offerings) {
		this.cdOfferings = offerings;
	}
	
	public CDOffering addCDOffering(CDOffering cdOffering) {
		cdOfferings.add(cdOffering);
		return cdOffering;
	}

	public void clearCDOfferings() {
		cdOfferings.clear();
	}

	public double totalBalances() {
		double total = 0;
		for (int i = 0; i < accountHolders.size(); i++) {
			total += accountHolders.get(i).getCombinedBalance();
		}
		return total;
	}
	
	//Add checking account
	
	public CheckingAccount addCheckingAccount(int id, CheckingAccount checkingAccount) throws ExceedsCombinedBalanceLimitException {
		for(AccountHolder ch: accountHolders) {
			if(ch.getId()==id) {
				ch.addCheckingAccount(checkingAccount);
			}
		}
		return checkingAccount;
	}

}
