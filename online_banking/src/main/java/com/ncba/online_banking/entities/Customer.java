package com.ncba.online_banking.entities;


import com.ncba.online_banking.Helpers.CustomerStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String idNumber;
    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    private String verificationCode;

}
