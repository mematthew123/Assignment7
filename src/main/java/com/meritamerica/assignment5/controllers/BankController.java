package com.meritamerica.assignment5.controllers;

import com.meritamerica.assignment5.service.MeritBank;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.Exceptions.NoSuchAccountException;
import com.meritamerica.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.models.CDOffering;

@RestController
public class BankController {
	
	@Autowired
	private MeritBank bankService;
	
	//CDOfferings
	@GetMapping("/CDOfferings")
	public List<CDOffering> getCDOfferings() {
		return bankService.getCDOfferings();
	}
	
	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public String addCDOffering(@RequestBody CDOffering cdOffering) {
		bankService.addCDOffering(cdOffering);
		return "CDOfferring successfully added";
	}
	
	//AccountHolders
	@GetMapping("/accountHolders")
	public List<AccountHolder> getAccountHolders() {
		return bankService.getAccountHolders();
	}
	
	@GetMapping("/accountHolders/{accountHolderID}")
	public AccountHolder getAccountHolder(@PathVariable String accountHolderID) throws NoSuchAccountException {
		int accHolderID = Integer.parseInt(accountHolderID);
		if(accHolderID>bankService.getAccountHolders().size()) {
			throw new NoSuchAccountException("No such account");
		}
		AccountHolder accountHold = bankService.getAccountHolder(accHolderID);
		return accountHold;
	}
	
	@PostMapping("/accountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public String addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		bankService.addAccountHolder(accountHolder);
		return "AccountHolder successfully added";
	}
	
	
}
