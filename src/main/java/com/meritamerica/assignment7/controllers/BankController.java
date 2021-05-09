package com.meritamerica.assignment7.controllers;
//package com.meritamerica.assignment6.controllers;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.meritamerica.assignment6.Exceptions.ExceedsCombinedBalanceLimitException;
//import com.meritamerica.assignment6.Exceptions.InterestRateNotInRangeException;
//import com.meritamerica.assignment6.Exceptions.InvalidArgumentException;
//import com.meritamerica.assignment6.Exceptions.NoSuchAccountException;
//import com.meritamerica.assignment6.models.AccountHolder;
//import com.meritamerica.assignment6.models.CDAccount;
//import com.meritamerica.assignment6.models.CDOffering;
//import com.meritamerica.assignment6.models.CheckingAccount;
//import com.meritamerica.assignment6.models.SavingsAccount;
//import com.meritamerica.assignment6.service.MeritBank;
//
//@RestController
//public class BankController {
//	Logger logs = LoggerFactory.getLogger(BankController.class);
//
//	// Bank Service
//	@Autowired
//	private MeritBank bankService;
//
//	@GetMapping("/")
//	public String home() {
//		return "Welcome to Merit Bank";
//	}
//
//	/**
//	 * Get CDOfferings
//	 * 
//	 * @return list of CDOfferings
//	 */
//	@GetMapping("/CDOfferings")
//	public List<CDOffering> getCDOfferings() {
//		return bankService.getCDOfferings();
//	}
//
//	@GetMapping("/CDOfferings/{id}")
//	public CDOffering getCDOffering(@PathVariable("id") int id) throws NoSuchAccountException {
//		if (id > bankService.getCDOfferings().size()) {
//			throw new NoSuchAccountException("Account with this id does not exist");
//		}
//		CDOffering cdOffering = null;
//		for (CDOffering cdof : bankService.getCDOfferings()) {
//			if (cdof.getId() == id) {
//				cdOffering = cdof;
//			}
//		}
//		return cdOffering;
//	}
//
//	/**
//	 * Post CDOffering Adds CDOffering to the list of CDOfferings
//	 * 
//	 * @return CDOffering
//	 */
//	@PostMapping("/CDOfferings")
//	@ResponseStatus(HttpStatus.CREATED)
//	public CDOffering addCDOffering(@RequestBody CDOffering cdOffering) throws InvalidArgumentException {
//		if (cdOffering.getInterestRate() <= 0 || cdOffering.getInterestRate() >= 1 || cdOffering.getTerm() < 1) {
//			throw new InvalidArgumentException("Invalid Term or Interest Rate");
//		}
//		CDOffering cdof = new CDOffering(cdOffering.getInterestRate(), cdOffering.getTerm());
//		bankService.addCDOffering(cdof);
//		return cdof;
//	}
//
//	/**
//	 * Get List of Account Holders
//	 * 
//	 * @return accountHolders
//	 */
//	@GetMapping("/accountHolders")
//	public List<AccountHolder> getAccountHolders() {
//		return bankService.getAccountHolders();
//	}
//
//	/**
//	 * Get account holder by id
//	 * 
//	 * @param accountHolderID
//	 * @return accountHolderID
//	 * @throws NoSuchAccountException
//	 */
//	@GetMapping("/accountHolders/{accountHolderID}")
//	public AccountHolder getAccountHolder(@PathVariable int accountHolderID) throws NoSuchAccountException {
//		if (accountHolderID > bankService.getAccountHolders().size()) {
//			logs.warn("No account exists");
//			throw new NoSuchAccountException("No such account");
//		}
//		AccountHolder accountHold = bankService.getAccountHolder(accountHolderID);
//		return accountHold;
//	}
//
////	Add account holder
//	/**
//	 * Add account holder Method: Post
//	 * 
//	 * @param accountHolder
//	 * @return accountHolder
//	 */
//	@PostMapping("/accountHolders")
//	@ResponseStatus(HttpStatus.CREATED)
//	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
//		bankService.addAccountHolder(accountHolder);
//		return accountHolder;
//	}
//
//	// Add checking account
//	/**
//	 * Creates a new checking account associated with the account holder with the
//	 * given ID and adds it to the account holder's list of checking accounts
//	 * 
//	 * @param id
//	 * @param checkingAccount
//	 * @return
//	 * @throws ExceedsCombinedBalanceLimitException
//	 */
//	@PostMapping("/accountHolders/{id}/checkingAccounts")
//	@ResponseStatus(HttpStatus.CREATED)
//	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody CheckingAccount checkingAccount)
//			throws ExceedsCombinedBalanceLimitException {
//		AccountHolder accountHolder = bankService.getAccountHolder(id);
//		CheckingAccount cha = new CheckingAccount(checkingAccount.getBalance());
//		accountHolder.addCheckingAccount(cha);
//		return cha;
//	}
//
//	// Get checking account
//	/**
//	 * Returns all checking accounts held by the account holder with the given ID
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@GetMapping("/accountHolders/{id}/checkingAccounts")
//	public List<CheckingAccount> getCheckingAccounts(@PathVariable int id) {
//		return bankService.getAccountHolder(id).getCheckingAccounts();
//	}
//
//	// Add savings account
//	/**
//	 * Creates a new savings account associated with the account holder with the
//	 * given ID
//	 * 
//	 * @param id
//	 * @param savingsAccount
//	 * @return savingsAccount
//	 * @throws ExceedsCombinedBalanceLimitException
//	 */
//	@PostMapping("/accountHolders/{id}/savingsAccounts")
//	@ResponseStatus(HttpStatus.CREATED)
//	public SavingsAccount addSavingsAccounts(@PathVariable int id, @RequestBody SavingsAccount savingsAccount)
//			throws ExceedsCombinedBalanceLimitException {
//		AccountHolder accountHolder = bankService.getAccountHolder(id);
//		SavingsAccount sva = new SavingsAccount(savingsAccount.getBalance());
//		accountHolder.addSavingsAccount(sva);
//		return sva;
//	}
//
//	// Get checking account
//	/**
//	 * Returns all savings accounts held by the account holder with the given ID
//	 * 
//	 * @param id
//	 * @return savingsAccounts
//	 */
//	@GetMapping("/accountHolders/{id}/savingsAccounts")
//	public List<SavingsAccount> getSavingsAccounts(@PathVariable int id) {
//		return bankService.getAccountHolder(id).getSavingsAccounts();
//	}
//
//	// Add CD account
//	/**
//	 * Creates a new CD account associated with the account holder with the given ID
//	 * 
//	 * @param id
//	 * @param cdAccount
//	 * @return cdAccount
//	 * @throws ExceedsCombinedBalanceLimitException
//	 */
//	@PostMapping("/accountHolders/{id}/cdAccounts")
//	@ResponseStatus(HttpStatus.CREATED)
//	public CDAccount addCDAccount(@PathVariable int id, @RequestBody CDAccount cdAccount)
//			throws ExceedsCombinedBalanceLimitException {
//		AccountHolder accountHolder = bankService.getAccountHolder(id);
//		CDOffering cdo = bankService.getCDOffering(cdAccount.getCdOffering().getId());
//		CDAccount cdAcc = new CDAccount(cdAccount.getBalance(), cdo);
//		accountHolder.addCdAccount(cdAcc);
//		return cdAcc;
//	}
//
//	// Get CD Accounts
//	/**
//	 * Returns all CD accounts held by the account holder with the given ID
//	 * 
//	 * @param id
//	 * @return cdAccount
//	 */
//	@GetMapping("/accountHolders/{id}/cdAccounts")
//	public List<CDAccount> getCDAccounts(@PathVariable int id) {
//		return bankService.getAccountHolder(id).getCdAccounts();
//	}
//}
