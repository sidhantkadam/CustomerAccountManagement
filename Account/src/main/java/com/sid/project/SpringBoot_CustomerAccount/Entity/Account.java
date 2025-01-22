package com.sid.project.SpringBoot_CustomerAccount.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity
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
}
