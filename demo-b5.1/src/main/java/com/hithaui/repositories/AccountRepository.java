package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.AccountDAO;

@Repository
public interface AccountRepository extends JpaRepository<AccountDAO, Long>{
	
//	@Query(value = "SELECT * FROM accounts WHERE username = ?1", nativeQuery = true)
	AccountDAO findByUsername(String username);
}
