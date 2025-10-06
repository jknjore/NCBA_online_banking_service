package com.ncba.online_banking.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    public String name;
    public String email;
    public String password;
    public String idNumber;
    public String mobileNumber;
}
