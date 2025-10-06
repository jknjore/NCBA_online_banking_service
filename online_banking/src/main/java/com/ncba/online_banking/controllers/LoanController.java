package com.ncba.online_banking.controllers;

import com.ncba.online_banking.Responses.ApiResponse;
import com.ncba.online_banking.dtos.LoanApplicationDto;
import com.ncba.online_banking.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
    @Autowired private LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<ApiResponse> apply(@RequestBody LoanApplicationDto dto) {
        String schedule = loanService.applyLoan(dto);
        return ResponseEntity.ok(ApiResponse.success("Loan application successful", schedule));
    }

}
