package com.sid.project.SpringBoot_Loans.DTO;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "loans")
public record LoansContactInfoDto(String message, Map<String, String> contactDetails, Long onCallSupport) {

}
