package com.sid.project.SpringBoot_CustomerAccount.Service;

import java.util.Optional;
import java.util.Random;
import com.sid.project.SpringBoot_CustomerAccount.Constants.AccountsConstants;
import com.sid.project.SpringBoot_CustomerAccount.DTO.AccountDto;
import com.sid.project.SpringBoot_CustomerAccount.DTO.CustomerDto;
import com.sid.project.SpringBoot_CustomerAccount.Entity.Account;
import com.sid.project.SpringBoot_CustomerAccount.Entity.Customer;
import com.sid.project.SpringBoot_CustomerAccount.Exception.CustomerAlreadyExistsException;
import com.sid.project.SpringBoot_CustomerAccount.Exception.ResourceNotFoundException;
import com.sid.project.SpringBoot_CustomerAccount.ModelMapper.ModelMapper;
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
	private ModelMapper modelMapper;

	@Override
	public void createAccount(CustomerDto customerDto)
	{
		Customer customer = modelMapper.customerDtoToCustomer(customerDto);
		Optional<Customer> optionalCustomer = customerRepo.findByMobileNo(customer.getMobileNo());
		if(optionalCustomer.isPresent())
		{
			throw new CustomerAlreadyExistsException("Customer already registered with given mobileNo "
					+ customer.getMobileNo());
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
		newAccount.setAccountType(AccountsConstants.SAVINGS);
		newAccount.setBranchAddress(AccountsConstants.ADDRESS);
		return newAccount;
	}

	@Override
	public CustomerDto fetchAccount(String mobileNo)
	{
		Customer customer = customerRepo.findByMobileNo(mobileNo)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNo", mobileNo));
		
		Account account = accountRepo.findByCustomerId(customer.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
		);
		
		CustomerDto customerDto = modelMapper.customerToCustomerDto(customer);
		AccountDto accountDto = modelMapper.accountToAccountDto(account);
		customerDto.setAccountDto(accountDto);
		return customerDto;
	}

	@Override
	public CustomerDto updateAccount(CustomerDto customerDto)
	{

		Account CheckAccount = accountRepo.findById(customerDto.getAccountDto().getAccountNo())
				.orElseThrow(()-> new ResourceNotFoundException("Account", "AccountNo.", customerDto.getAccountDto().getAccountNo().toString()));
		AccountDto accountDto  = customerDto.getAccountDto();
		Account account = modelMapper.accountDtoToAccount(accountDto);
		account.setCustomerId(CheckAccount.getCustomerId());
		accountRepo.save(account);

		Long customerId = account.getCustomerId();

        Customer CheckCustomer = customerRepo.findByCustomerId(account.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "CustomerId", customerId.toString()));
		Customer customer = modelMapper.customerDtoToCustomer(customerDto);
		customer.setCustomerId(CheckCustomer.getCustomerId());
        customerRepo.save(customer);

        return customerDto;
	}

	@Override
	public boolean deleteAccount(String mobileNo)
	{
		Customer customer = customerRepo.findByMobileNo(mobileNo)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNo", mobileNo));
		accountRepo.deleteAccountByCustomerId(customer.getCustomerId());
		customerRepo.deleteById(customer.getCustomerId());
		return true;
	}
}
