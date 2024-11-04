package com.sid.project.SpringBoot_CustomerAccount.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@NotEmpty
	private String name;
	@NotNull
	private Long mobileNo;
	@NotNull
	private String email;

	public Customer(Long customerId, String name, Long mobileNo, String email) {
		this.customerId = customerId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public @NotEmpty String getName() {
		return name;
	}

	public void setName(@NotEmpty String name) {
		this.name = name;
	}

	public @NotNull Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(@NotNull Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public @NotNull String getEmail() {
		return email;
	}

	public void setEmail(@NotNull String email) {
		this.email = email;
	}
}
