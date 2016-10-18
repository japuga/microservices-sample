package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Account;

public interface AccountRepositoryInterface extends JpaRepository<Account, Long> {

}
