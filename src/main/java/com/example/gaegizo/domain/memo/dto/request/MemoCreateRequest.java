package com.example.gaegizo.domain.memo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemoCreateRequest {

    private Long compareBoxId;
    private String content;
}
