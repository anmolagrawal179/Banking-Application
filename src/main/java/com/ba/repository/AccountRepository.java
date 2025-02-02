package com.ba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ba.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByBalanceBetween(Double min, Double max);

}
