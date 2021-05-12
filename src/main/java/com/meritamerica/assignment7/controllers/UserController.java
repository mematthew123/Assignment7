package com.meritamerica.assignment7.controllers;

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

import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.models.AccountHoldersContactDetails;
import com.meritamerica.assignment7.service.AccountHolderService;




// Needs User Security Package and classes//



//public class UserController {
//
////	@Autowired
////	private UserService userservice; *need to create userclass to import
////	
////	@PostMapping("/authenticate/createuser")
////	@ResponseStatus(HttpStatus.CREATED)
////	Public User addUser (RequestBody User user) {
////		return userService.addUser(user);
////	}
//
