package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Account;

public interface AccountRepositoryInterface extends JpaRepository<Account, Long> {
	
	
	@Query("select a from Account a where a.userId = ?1")
	List<Account> findAccountsByUserId(long userId);

}
