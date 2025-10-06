package com.ncba.online_banking.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationDto {
    public Long accountId;
    public double amount;
    public int tenure;
}

