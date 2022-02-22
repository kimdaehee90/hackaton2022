package com.example.gaegizo.domain.memo.dto.response;

import com.example.gaegizo.domain.memo.dto.MemoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GetMemoResponse {

    private MemoDto data;

}
