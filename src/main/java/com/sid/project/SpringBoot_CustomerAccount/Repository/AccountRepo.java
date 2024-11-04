package com.sid.project.SpringBoot_CustomerAccount.Repository;

import com.sid.project.SpringBoot_CustomerAccount.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>
{
	Account findByCustomerId(Long customerId);

	Account deleteAccountByCustomerId(Long customerId);	
}
