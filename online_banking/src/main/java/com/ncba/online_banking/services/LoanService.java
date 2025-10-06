package com.ncba.online_banking.services;


import com.ncba.online_banking.dtos.LoanApplicationDto;

public interface LoanService {
    String applyLoan(LoanApplicationDto dto);
}

