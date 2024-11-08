package com.sid.project.SpringBoot_Loans.Service;

import com.sid.project.SpringBoot_Loans.DTO.LoanDTO;


public interface LoanService
{
    void createLoan(String mobileNo);

    LoanDTO fetchLoan(String mobileNo);

    boolean updateLoan(LoanDTO loanDto);

    boolean deleteLoan(String mobileNo);
}
