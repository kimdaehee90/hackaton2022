package com.example.gaegizo.domain.memo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GetMemoRequest {

    private Long memoId;
    private Long compareBox;
}
