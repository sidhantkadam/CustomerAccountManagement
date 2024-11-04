package com.sid.project.SpringBoot_CustomerAccount.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Account
{
	@Id
	@NotNull
	private Long accountNo;
	@NotNull
	private Long customerId;
	@NotEmpty
	private String branchAddress;
	@NotEmpty
	private String accountType;


	public @NotNull Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(@NotNull Long accountNo) {
		this.accountNo = accountNo;
	}

	public @NotNull Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(@NotNull Long customerId) {
		this.customerId = customerId;
	}

	public @NotEmpty String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(@NotEmpty String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public @NotEmpty String getAccountType() {
		return accountType;
	}

	public void setAccountType(@NotEmpty String accountType) {
		this.accountType = accountType;
	}
}
