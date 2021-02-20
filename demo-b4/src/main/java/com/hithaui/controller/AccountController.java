package com.hithaui.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.NotFoundException;
import com.hithaui.dao.Account;
import com.hithaui.dto.AccountDTO;
import com.hithaui.repositories.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts(){
		List<Account> list = accountRepository.findAll();
		return list;
	}
	
	@PostMapping("/accounts")
	public Account createNewAccount(@RequestBody AccountDTO accountDTO) {
		Account account = new Account();
		account.setUsername(accountDTO.getUsername());
		account.setPassword(accountDTO.getPassword());
		
		Account newAccount = accountRepository.save(account);
		return newAccount;
	}
	
	@GetMapping("/accounts/{accountId}")
	public Account getAccountById(@PathVariable("accountId") Integer id) {
		Optional<Account> account = accountRepository.findById(id);
		if(!account.isPresent()) {
			throw new NotFoundException("Not found account by account id: " + id);
		}
		return account.get();
	}
}
