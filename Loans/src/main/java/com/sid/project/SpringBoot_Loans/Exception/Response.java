package com.sid.project.SpringBoot_Loans.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response
{

    private String statusCode;

    private String statusMsg;
}
