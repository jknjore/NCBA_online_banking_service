package com.ncba.online_banking.controllers;

import com.ncba.online_banking.Responses.ApiResponse;
import com.ncba.online_banking.dtos.FundAccountDto;
import com.ncba.online_banking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired private AccountService accountService;


    @PostMapping("/fund")
    public ResponseEntity<ApiResponse> fund(@RequestBody FundAccountDto dto) {
        accountService.fundAccount(dto);
        return ResponseEntity.ok(ApiResponse.success("Account funded successfully", null));
    }

}