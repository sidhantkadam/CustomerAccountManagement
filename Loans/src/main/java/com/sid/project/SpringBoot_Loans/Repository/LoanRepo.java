package com.sid.project.SpringBoot_Loans.Repository;

import com.sid.project.SpringBoot_Loans.Entity.Loan;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long>
{
    Optional<Loan> findByMobileNo(String mobileNo);

    Optional<Loan> findByLoanNumber(String loanNumber);

}
