package com.example.gaegizo.domain.exception.controller;

import com.example.gaegizo.domain.exception.GaegizoException;
import com.example.gaegizo.domain.exception.dto.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(GaegizoException.class)
    public ExceptionResponse GaegizoExceptionHandler(GaegizoException e, HttpServletRequest request) {
        log.error("errorCode = {}, message = {}, requestURL = {}", e.getErrorCode(), e.getMessage(), request.getRequestURL());
        return ExceptionResponse.builder()
                .errorCode(e.getErrorCode())
                .message(e.getMessage())
                .build();
    }
}
