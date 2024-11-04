package com.sid.project.SpringBoot_CustomerAccount.Service;

import com.sid.project.SpringBoot_CustomerAccount.DTO.CustomerDto;

public interface AccountService
{
	void createAccount(CustomerDto customerDto);
	
	CustomerDto fetchAccount(Long mobileNo);
	
	boolean updateAccount(CustomerDto customerDto);
	
	boolean deleteAccount(Long mobileNo);

}
