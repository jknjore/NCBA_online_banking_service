package com.ncba.online_banking.controllers;


import com.ncba.online_banking.dtos.CustomerDto;
import com.ncba.online_banking.dtos.VerificationDto;
import com.ncba.online_banking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired private CustomerService customerService;

    @PostMapping("/register")
    public void register(@RequestBody CustomerDto dto) {
        customerService.register(dto);
    }

    @PostMapping("/verify")
    public void verify(@RequestBody VerificationDto dto) {
        customerService.verify(dto);
    }
}