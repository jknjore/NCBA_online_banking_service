package com.ncba.online_banking.repositories;


import com.ncba.online_banking.entities.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
}