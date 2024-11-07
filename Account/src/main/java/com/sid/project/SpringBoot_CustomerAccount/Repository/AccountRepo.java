package com.sid.project.SpringBoot_CustomerAccount.Repository;

import com.sid.project.SpringBoot_CustomerAccount.Entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>
{
	Optional<Account> findByCustomerId(Long customerId);

	@Transactional
	@Modifying
	void deleteAccountByCustomerId(Long customerId);

}
