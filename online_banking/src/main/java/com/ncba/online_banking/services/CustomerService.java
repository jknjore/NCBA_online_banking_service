package com.ncba.online_banking.services;


import com.ncba.online_banking.dtos.CustomerDto;
import com.ncba.online_banking.dtos.VerificationDto;
import com.ncba.online_banking.entities.Customer;

public interface CustomerService {
    Customer register(CustomerDto dto);
    Customer verify(VerificationDto dto);
}
