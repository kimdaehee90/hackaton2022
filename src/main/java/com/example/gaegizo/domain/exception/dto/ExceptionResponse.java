package com.example.gaegizo.domain.exception.dto;

import com.example.gaegizo.domain.exception.GaegizoErrorCode;
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
