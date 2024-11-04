package com.sid.project.SpringBoot_CustomerAccount.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
public class ErrorInfo
{
    private  String apiPath;
    private HttpStatus errorCode;
    private  String errorMessage;
    private LocalDateTime errorTime;

    public ErrorInfo(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorTime) {
        this.apiPath = apiPath;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }
}
