package com.sid.project.SpringBoot_CustomerAccount.Service;

import com.sid.project.SpringBoot_CustomerAccount.DTO.CustomerDto;

public interface AccountService
{
	void createAccount(CustomerDto customerDto);
	
	CustomerDto fetchAccount(String mobileNo);
	
	CustomerDto updateAccount(CustomerDto customerDto, Long customerId);
	
	boolean deleteAccount(String mobileNo);

}
