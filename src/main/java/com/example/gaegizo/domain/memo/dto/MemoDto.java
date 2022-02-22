package com.example.gaegizo.domain.memo.dto;

import com.example.gaegizo.domain.memo.domain.Memo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MemoDto {

    private String content;

    public static MemoDto from(Memo memo) {
        return MemoDto.builder()
                .content(memo.getContent())
                .build();
    }
}
