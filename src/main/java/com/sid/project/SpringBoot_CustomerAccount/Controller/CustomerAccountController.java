package com.sid.project.SpringBoot_CustomerAccount.Controller;


import com.sid.project.SpringBoot_CustomerAccount.Constants.AccountsConstants;
import com.sid.project.SpringBoot_CustomerAccount.DTO.CustomerDto;
import com.sid.project.SpringBoot_CustomerAccount.DTO.ResponseDto;
import com.sid.project.SpringBoot_CustomerAccount.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@Validated
@AllArgsConstructor
public class CustomerAccountController
{
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/createAccount")
	public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto)
	{
		accountService.createAccount(customerDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}
	
	@GetMapping("/fetchAccount")
	public ResponseEntity<CustomerDto> fetchAccount(@RequestParam Long mobileNo)
	{
		CustomerDto customerDto = accountService.fetchAccount(mobileNo);
		return ResponseEntity.status(HttpStatus.FOUND).body(customerDto);
	}
	
	@DeleteMapping("/deleteAccount")
	public ResponseEntity<Boolean> deleteAccount(@RequestParam Long mobileNo)
	{
		boolean isDelete = accountService.deleteAccount(mobileNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "hello";
	}
}
