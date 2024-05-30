package com.example.GP.exception;

import com.example.GP.dto.error.ErrorResponse;
import com.example.GP.exception.Gonjeong.BusinessException;
import com.example.GP.exception.Gonjeong.CompanyException;
import com.example.GP.exception.Gonjeong.DepartmentException;
import com.example.GP.exception.Gonjeong.UserException;
import com.example.GP.type.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ErrorResponse handleUserException(UserException e) {
        log.error("{} is occurred !", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(DepartmentException.class)
    public ErrorResponse handleDepartmentException(DepartmentException e) {
        log.error("{} is occurred !", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(CompanyException.class)
    public ErrorResponse handleCompanyException(CompanyException e) {
        log.error("{} is occurred !", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ErrorResponse handleBusinessException(BusinessException e) {
        log.error("{} is occurred !", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse handleDataIntegrityViolationExceptionException(DataIntegrityViolationException e) {

        log.error("DataIntegrityViolationException is occurred !", e);
        return new ErrorResponse(ErrorCode.INVALID_REQUEST, ErrorCode.INVALID_REQUEST.getDescription());
    }
    @ExceptionHandler
    public ErrorResponse handleException(Exception e) {
        log.error("Exception is occurred !", e);
        return new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR.getDescription());
    }
}
