package com.sid.project.SpringBoot_Loans.ModelMapper;

import com.sid.project.SpringBoot_Loans.DTO.LoanDTO;
import com.sid.project.SpringBoot_Loans.Entity.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModelMapper
{
    Loan loanDtoToLoan(LoanDTO loansDTO);

    LoanDTO loanEntityToLoanDto(Loan loan);
}
