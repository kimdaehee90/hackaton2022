package com.example.gaegizo.domain.exception;

import lombok.Getter;

@Getter
public class GaegizoException extends RuntimeException {
    private GaegizoErrorCode errorCode;
    private String message;

    public GaegizoException(GaegizoErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
