package com.example.GP.exception.Gonjeong;


import com.example.GP.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyException extends RuntimeException {

    private ErrorCode errorCode;
    private String errorMessage;

    public CompanyException(ErrorCode errorCode) {
    this.errorCode = errorCode;
    this.errorMessage = errorCode.getDescription();
    }
}


