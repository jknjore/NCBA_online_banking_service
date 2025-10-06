package com.ncba.online_banking.controllers;

import com.ncba.online_banking.dtos.FundAccountDto;
import com.ncba.online_banking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired private AccountService accountService;

    @PostMapping("/fund")
    public void fund(@RequestBody FundAccountDto dto) {
        accountService.fundAccount(dto);
    }
}