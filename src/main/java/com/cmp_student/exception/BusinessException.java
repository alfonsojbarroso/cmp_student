package com.cmp_student.exception;

import com.cmp_student.dto.ErrorMessageDto;

public class BusinessException extends RuntimeException {

    private String message;
    private ErrorMessageDto errorMessageDto;

    public BusinessException(ErrorMessageDto errorMessageDto) {
        super(errorMessageDto.message());
        this.errorMessageDto = errorMessageDto;
    }

    public String getMessage() {
        return message;
    }

    public ErrorMessageDto getErrorMessageDto() {
        return errorMessageDto;
    }

}
