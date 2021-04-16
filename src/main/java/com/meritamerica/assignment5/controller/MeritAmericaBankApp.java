package com.meritamerica.assignment5.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.models.AccountHolder;

@RestController
public class MeritAmericaBankApp {
	ArrayList<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	AccountHolder accHolder = new AccountHolder("John", "A", "Doe", "000-222-3333");
	AccountHolder accHolder2 = new AccountHolder("Jane", "A", "Doe", "000-555-1111");
	
	//accountHolders.add(accHolder);
	
	@GetMapping("/accountHolders")
	public AccountHolder home() {
		return accHolder2;
	}
}
