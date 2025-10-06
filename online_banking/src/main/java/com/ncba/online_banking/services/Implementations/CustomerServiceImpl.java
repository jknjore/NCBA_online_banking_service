package com.ncba.online_banking.services.Implementations;

import com.ncba.online_banking.Helpers.CustomerStatus;
import com.ncba.online_banking.dtos.CustomerDto;
import com.ncba.online_banking.dtos.VerificationDto;
import com.ncba.online_banking.entities.Account;
import com.ncba.online_banking.entities.Customer;
import com.ncba.online_banking.repositories.AccountRepository;
import com.ncba.online_banking.repositories.CustomerRepository;
import com.ncba.online_banking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Customer register(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.name);
        customer.setEmail(dto.email);
        customer.setPassword(dto.password);
        customer.setIdNumber(dto.idNumber);
        customer.setMobileNumber(dto.mobileNumber);
        customer.setStatus(CustomerStatus.PENDING_VERIFICATION);
        customer.setVerificationCode(UUID.randomUUID().toString().substring(0, 6));
        Customer saved = customerRepository.save(customer);

        System.out.println("Mock email sent with code: " + saved.getVerificationCode());
        return saved;
    }

    @Override
    public Customer verify(VerificationDto dto) {
        Customer customer = customerRepository.findByEmail(dto.email);
        if (customer != null && customer.getVerificationCode().equals(dto.verificationCode)) {
            customer.setStatus(CustomerStatus.ACTIVE);
            customerRepository.save(customer);

            Account account = new Account();
            account.setCustomerId(customer.getId());
            account.setBalance(0);
            accountRepository.save(account);
        }
        return customer;
    }
}

