package com.sid.project.SpringBoot_CustomerAccount.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;


public class CustomerDto 
{
	@NotEmpty
	private String name;
	@NotNull
	private Long mobileNo;
	@NotEmpty
	private String email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public @NotEmpty String getEmail() {
		return email;
	}

	public void setEmail(@NotEmpty String email) {
		this.email = email;
	}

	public AccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDto accountDto) 
	{
		this.accountDto = accountDto;
	}

	private AccountDto accountDto;

	public CustomerDto(@NotEmpty String name, @NotNull Long mobileNo, @NotEmpty String email, AccountDto accountDto) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.accountDto = accountDto;
	}

	public CustomerDto() {
	
	}
}
