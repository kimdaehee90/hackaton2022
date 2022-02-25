package com.example.gaegizo.exception.dto;

import com.example.gaegizo.exception.GaegizoErrorCode;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponse {

    private GaegizoErrorCode errorCode;
    private String message;
}
