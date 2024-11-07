package com.sid.project.SpringBoot_CustomerAccount.Repository;

import java.util.Optional;

import com.sid.project.SpringBoot_CustomerAccount.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>
{

	Optional<Customer> findByCustomerId(Long customerId);

	Optional<Customer> findByMobileNo(String mobileNo);
}
