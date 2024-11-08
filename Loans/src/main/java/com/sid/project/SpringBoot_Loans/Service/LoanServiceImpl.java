package com.sid.project.SpringBoot_Loans.Service;

import com.sid.project.SpringBoot_Loans.Constants.LoanConstants;
import com.sid.project.SpringBoot_Loans.DTO.LoanDTO;
import com.sid.project.SpringBoot_Loans.Entity.Loan;
import com.sid.project.SpringBoot_Loans.Exception.LoanAlreadyExistsException;
import com.sid.project.SpringBoot_Loans.Exception.ResourceNotFoundException;
import com.sid.project.SpringBoot_Loans.ModelMapper.ModelMapper;
import com.sid.project.SpringBoot_Loans.Repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoanServiceImpl implements LoanService
{
    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createLoan(String mobileNo)
    {
        Optional<Loan> loan = loanRepo.findByMobileNo(mobileNo);
        if(loan.isPresent())
        {
            throw new LoanAlreadyExistsException("Loan already exists for mobileNo : " + mobileNo);
        }
        loanRepo.save(createNewLoan(mobileNo));
    }

    private Loan createNewLoan(String mobileNumber)
    {
        Loan newLoan = new Loan();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNo(mobileNumber);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoanDTO fetchLoan(String mobileNo)
    {
        Loan loan = loanRepo.findByMobileNo(mobileNo)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNo", mobileNo)
        );
        return modelMapper.loanEntityToLoanDto(loan);
    }

    @Override
    public boolean updateLoan(LoanDTO loanDto)
    {
        Loan checkLoan = loanRepo.findByLoanNumber(loanDto.getLoanNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "LoanNo", loanDto.getMobileNo()));
        Loan loan = modelMapper.loanDtoToLoan(loanDto);
        loan.setLoanId(checkLoan.getLoanId());
        loanRepo.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNo)
    {
        Loan loan = loanRepo.findByMobileNo(mobileNo)
                .orElseThrow(()-> new ResourceNotFoundException("Loan", "MobileNo", mobileNo));
        loanRepo.deleteById(loan.getLoanId());
        return true;
    }
}
