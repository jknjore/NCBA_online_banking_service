package com.ncba.online_banking.controllers;


import com.ncba.online_banking.Responses.ApiResponse;
import com.ncba.online_banking.dtos.CustomerDto;
import com.ncba.online_banking.dtos.VerificationDto;
import com.ncba.online_banking.entities.Customer;
import com.ncba.online_banking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired private CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody CustomerDto dto) {
        Customer customer = customerService.register(dto);
        return ResponseEntity.ok(ApiResponse.success("Customer registered successfully", customer));
    }

    @PostMapping("/verify")
    public ResponseEntity<ApiResponse> verify(@RequestBody VerificationDto dto) {
        Customer customer = customerService.verify(dto);
        return ResponseEntity.ok(ApiResponse.success("Customer verified and account created", customer));
    }

}