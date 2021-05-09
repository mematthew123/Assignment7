package com.meritamerica.assignment7.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment7.Exceptions.InvalidArgumentException;
import com.meritamerica.assignment7.models.CDOffering;
import com.meritamerica.assignment7.service.CDOfferingService;

@RestController
public class CDOfferingController {
	Logger logs = LoggerFactory.getLogger(AccountsController.class);

	@Autowired
	private CDOfferingService cdOfferingService;

	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering addCDOffering(@RequestBody CDOffering cdOffering) throws InvalidArgumentException {
		return cdOfferingService.addCDOffering(cdOffering);
	}

	@GetMapping("/CDOfferings")
	public List<CDOffering> getCDOfferings() {
		return cdOfferingService.getCDOfferings();
	}
}