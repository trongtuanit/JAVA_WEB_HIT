package com.hithaui.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.dao.AccountDAO;
import com.hithaui.dto.AccountDTO;
import com.hithaui.repositories.AccountRepository;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
// 	RESTful API: CRUD (create, read, update, delete): 
//	GET 	/api/accounts 		: lấy ra danh sách tài khoản
//	POST	/api/accounts 		: tạo 1 tài khoản
//	GET	/api/accounts/{id}	: lấy ra tài khoản theo id
//	PATCH	/api/accounts/{id}    	: chỉnh sửa thông tin tài khoản
//	DELETE	/api/accounts/{id}	: xóa 1 tài khoản

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping
	public ResponseEntity<?> getAllAcounts(@RequestParam(value = "page", required = false) Integer page) {
		if(page != null) {
			Page<AccountDAO> listAccountOfPage = accountRepository.findAll(PageRequest.of(page.intValue(), 10));
			List<AccountDAO> listAccounts = listAccountOfPage.getContent();
			return ResponseEntity.status(200).body(listAccounts);
		}
		
		
		List<AccountDAO> list = accountRepository.findAll();
		if (list.size() == 0) {
			return ResponseEntity.status(204).build();
		}
		return ResponseEntity.status(200).body(list);
	}
	
	//Pagination
//	@GetMapping
//	public ResponseEntity<?> getAccountsByPagination(@RequestParam("page") Integer page){
//		
//		Page<AccountDAO> listAccountOfPage = accountRepository.findAll(PageRequest.of(page.intValue(), 10));
//		List<AccountDAO> listAccounts = listAccountOfPage.getContent();
//		return ResponseEntity.status(200).body(listAccounts);
//	}

	@PostMapping
	public ResponseEntity<?> createNewAccount(@RequestBody AccountDTO accountDTO) {
		AccountDAO accountDAO = new AccountDAO();
		
//		AccountDAO account = accountRepository.findByUsername(accountDTO.getUsername());
//		if(account != null) {
//			// Duplicate Exception
//		}
		accountDAO.setUsername(accountDTO.getUsername());
		accountDAO.setPassword(accountDTO.getPassword());

		AccountDAO newAccountDAO = accountRepository.save(accountDAO);
		return ResponseEntity.status(201).body(newAccountDAO);
	}

	@GetMapping("/{accountId}")
	public ResponseEntity<?> getAccountById(@PathVariable("accountId") Long accountId) {
		Optional<AccountDAO> accountDAO = accountRepository.findById(accountId);
		return ResponseEntity.status(200).body(accountDAO.get());
	}

	@PatchMapping("/{accountId}")
	public ResponseEntity<?> editAccountById(@PathVariable("accountId") Long accountId,
			@RequestBody AccountDTO accountDTO) {
		Optional<AccountDAO> optional = accountRepository.findById(accountId);
		AccountDAO accountDAO = optional.get();
		accountDAO.setPassword(accountDTO.getPassword());
		
		AccountDAO newAccountDAO = accountRepository.save(accountDAO);
		return ResponseEntity.status(200).body(newAccountDAO);
	}
	
	@DeleteMapping("/{accountId}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("accountId") Long accountId) {
		accountRepository.deleteById(accountId);
		return ResponseEntity.status(200).build();
	}
}
