package com.example.GP.exception.accountBook;

import com.example.GP.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseException extends RuntimeException {

    private ErrorCode errorCode;
    private String errorMessage;

    public ExpenseException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
