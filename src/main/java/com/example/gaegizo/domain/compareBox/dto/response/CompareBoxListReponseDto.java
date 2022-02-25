package com.example.gaegizo.domain.compareBox.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CompareBoxListReponseDto {

    private Long userId;
    private List<CompareBoxIdResponseDto> compareBoxIdResponseDtoList;

    public CompareBoxListReponseDto(Long userId, List<CompareBoxIdResponseDto> collect) {
        this.userId = userId;
        this.compareBoxIdResponseDtoList = collect;
    }
}
