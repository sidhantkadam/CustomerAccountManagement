package com.sid.project.SpringBoot_CustomerAccount.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class AccountDto 
{
	@NotNull
	private Long accountNo;
	@NotEmpty
	private String branchAddress;
	@NotEmpty
	private String accountType;
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public AccountDto(@NotNull Long accountNo, @NotEmpty String branchAddress, @NotEmpty String accountType) 
	{
		super();
		this.accountNo = accountNo;
		this.branchAddress = branchAddress;
		this.accountType = accountType;
	}
	public AccountDto() 
	{
	}
}
