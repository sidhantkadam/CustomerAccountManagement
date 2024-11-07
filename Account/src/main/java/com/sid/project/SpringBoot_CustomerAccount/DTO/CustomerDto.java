package com.sid.project.SpringBoot_CustomerAccount.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Data
public class CustomerDto 
{
	@NotEmpty(message = "Name can not be a null or empty")
	@Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
	private String name;
	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
	private String mobileNo;
	@NotEmpty
	@Email(message = "Email address should be a valid value")
	private String email;

	private AccountDto accountDto;
}
