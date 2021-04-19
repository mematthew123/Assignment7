package com.meritamerica.assignment5.controllers;

import com.meritamerica.assignment5.service.MeritBank;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.meritamerica.assignment5.Exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment5.Exceptions.InterestRateNotInRangeException;
import com.meritamerica.assignment5.Exceptions.NoSuchAccountException;
import com.meritamerica.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.models.CDAccount;
import com.meritamerica.assignment5.models.CDOffering;
import com.meritamerica.assignment5.models.CheckingAccount;

@RestController
public class BankController {
	Logger logs = LoggerFactory.getLogger(BankController.class);
	
	
	@Autowired
	private MeritBank meritBank;
	
	
	//CDOfferings
	@GetMapping("/CDOfferings")
	public List<CDOffering> getCDOfferings() {
		return meritBank.getCDOfferings();
	}
	
	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody CDOffering cdOffering) throws InterestRateNotInRangeException{
		if(cdOffering.getInterestRate()<=0 || cdOffering.getInterestRate()>=1) {
			throw new InterestRateNotInRangeException("Interest rate mush be between 0 and 1");
		}
		meritBank.addCDOffering(cdOffering);
		return cdOffering;
	}
	
	//Get AccountHolders
	@GetMapping("/accountHolders")
	public List<AccountHolder> getAccountHolders() {
		return meritBank.getAccountHolders();
	}
	
	@GetMapping("/accountHolders/{accountHolderID}")
	public AccountHolder getAccountHolder(@PathVariable String accountHolderID) throws NoSuchAccountException {
		int accHolderID = Integer.parseInt(accountHolderID);
		if(accHolderID>meritBank.getAccountHolders().size()) {
			throw new NoSuchAccountException("No such account");
		}
		AccountHolder accountHold = meritBank.getAccountHolder(accHolderID);
		return accountHold;
	}
	
	@PostMapping("/accountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		meritBank.addAccountHolder(accountHolder);
		return accountHolder;
	}
	
	//Get checking account
	@GetMapping("/accountHolders/{id}/checkingAccounts")
	public List<CheckingAccount> getCheckingAccounts(@PathVariable String id) {
		return meritBank.getAccountHolder(Integer.parseInt(id)).getCheckingAccounts();
	}
	
	//Post checking account
	@PostMapping("/accountHolders/{id}/checkingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody CheckingAccount checkingAccount) throws NumberFormatException, ExceedsCombinedBalanceLimitException {
		AccountHolder accountHolder = meritBank.getAccountHolder(id);
		CheckingAccount cha = new CheckingAccount(checkingAccount.getBalance());
		accountHolder.addCheckingAccount(cha);
		return cha;
	}
	
	@PostMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccounts(@PathVariable int id, @RequestBody CDAccount cdAccount) throws NumberFormatException, ExceedsCombinedBalanceLimitException {
		AccountHolder accountHolder = meritBank.getAccountHolder(id);
		CDOffering cdo = meritBank.getCDOffering(cdAccount.getOffering().getId());
		CDAccount cdAcc = new CDAccount(cdo, cdAccount.getAccountBalance());
		accountHolder.addCDAccount(cdAcc);
//		CheckingAccount cha = new CheckingAccount(cdAccount.getBalance());
//		accountHolder.addCheckingAccount(cha);
		return cdAcc;
	}
	
	
}
