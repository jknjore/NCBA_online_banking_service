package com.ncba.online_banking.services.Implementations;

import com.ncba.online_banking.dtos.FundAccountDto;
import com.ncba.online_banking.entities.Account;
import com.ncba.online_banking.repositories.AccountRepository;
import com.ncba.online_banking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired private AccountRepository accountRepository;

    @Override
    public void fundAccount(FundAccountDto dto) {
        Account account = accountRepository.findById(dto.accountId).orElseThrow();
        if (dto.amount < 500) throw new RuntimeException("Minimum funding is KES 500");
        account.setBalance(account.getBalance() + dto.amount);
        accountRepository.save(account);
    }
}
