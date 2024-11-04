package com.sid.project.SpringBoot_CustomerAccount.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResponseDto
{
        private String statusCode;
        private String statusMsg;

        public ResponseDto(String statusCode, String statusMsg)
        {
                this.statusCode = statusCode;
                this.statusMsg = statusMsg;
        }
}
