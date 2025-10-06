package com.ncba.online_banking.repositories;


import com.ncba.online_banking.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

