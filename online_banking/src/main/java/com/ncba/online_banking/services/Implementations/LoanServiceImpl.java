package com.ncba.online_banking.services.Implementations;


import com.ncba.online_banking.dtos.LoanApplicationDto;
import com.ncba.online_banking.entities.Account;
import com.ncba.online_banking.entities.LoanApplication;
import com.ncba.online_banking.repositories.AccountRepository;
import com.ncba.online_banking.repositories.LoanApplicationRepository;
import com.ncba.online_banking.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired private AccountRepository accountRepository;
    @Autowired private LoanApplicationRepository loanRepository;

    @Override
    public String applyLoan(LoanApplicationDto dto) {
        Account account = accountRepository.findById(dto.accountId).orElseThrow();

        if (account.getBalance() < 500) throw new RuntimeException("Account not funded with minimum KES 500");
        if (dto.amount < 1000 || dto.amount > 10000) throw new RuntimeException("Loan must be between KES 1,000 and 10,000");

        LoanApplication loan = new LoanApplication();
        loan.setAccountId(dto.accountId);
        loan.setAmount(dto.amount);
        loan.setTenure(dto.tenure);
        loanRepository.save(loan);

        return "Loan approved. Mock schedule: [KES " + dto.amount + " over " + dto.tenure + " months]";
    }
}
