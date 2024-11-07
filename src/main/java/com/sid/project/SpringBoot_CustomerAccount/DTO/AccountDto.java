package com.sid.project.SpringBoot_CustomerAccount.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
public class AccountDto 
{
	private Long accountNo;
	@NotEmpty(message = "BranchAddress can not be a null or empty")
	private String branchAddress;
	@NotEmpty(message = "AccountType can not be a null or empty")
	private String accountType;
}
