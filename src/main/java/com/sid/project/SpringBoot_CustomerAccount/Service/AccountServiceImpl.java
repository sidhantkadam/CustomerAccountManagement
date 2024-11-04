package com.sid.project.SpringBoot_CustomerAccount.Service;

import java.util.Optional;
import java.util.Random;
import com.sid.project.SpringBoot_CustomerAccount.DTO.AccountDto;
import com.sid.project.SpringBoot_CustomerAccount.DTO.CustomerDto;
import com.sid.project.SpringBoot_CustomerAccount.Entity.Account;
import com.sid.project.SpringBoot_CustomerAccount.Entity.Customer;
import com.sid.project.SpringBoot_CustomerAccount.Exception.CustomerAlreadyExistsException;
import com.sid.project.SpringBoot_CustomerAccount.ModelMapper.MapperClass;
import com.sid.project.SpringBoot_CustomerAccount.Repository.AccountRepo;
import com.sid.project.SpringBoot_CustomerAccount.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private MapperClass mapperclass;

	@Override
	public void createAccount(CustomerDto customerDto)
	{
		Customer customer = mapperclass.customerDtotoCustomer(customerDto);
		Optional<Customer> optionalCustomer = customerRepo.findByMobileNo(customer.getMobileNo());
		if(optionalCustomer.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
					+customerDto.getMobileNo());
		}
		Customer savedCustomer  = customerRepo.save(customer);
		accountRepo.save(createNewAccount(savedCustomer));
	}
	
	private Account createNewAccount(Customer customer)
	{
		Account newAccount = new Account();
		newAccount.setCustomerId(customer.getCustomerId());
		Long randomAcc = 100000000L + new Random().nextInt(900000000);
		newAccount.setAccountNo(randomAcc);
		newAccount.setAccountType("Savings");
		newAccount.setBranchAddress("Maharashtra India");
		return newAccount;
	}

	@Override
	public CustomerDto fetchAccount(Long mobileNo)
	{
		Optional<Customer> customer = customerRepo.findByMobileNo(mobileNo);
		
		Account account = accountRepo.findByCustomerId(customer.get().getCustomerId());
		
		CustomerDto customerDto = mapperclass.customerToCustomerDto(customer.get());
		AccountDto accountDto = mapperclass.accountToAccountDto(account);
		customerDto.setAccountDto(accountDto);
		return customerDto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) 
	{

		return false;
	}

	@Override
	public boolean deleteAccount(Long mobileNo) 
	{
		Customer customer = customerRepo.findByMobileNo(mobileNo)
				.orElseThrow();
		accountRepo.deleteAccountByCustomerId(customer.getCustomerId());
		customerRepo.deleteById(customer.getCustomerId());
		return true;
	}

}
