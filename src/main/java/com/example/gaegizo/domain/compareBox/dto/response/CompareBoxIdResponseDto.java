package com.example.gaegizo.domain.compareBox.dto.response;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompareBoxIdResponseDto {
    private Long compareBoxId;

    public CompareBoxIdResponseDto(CompareBox compareBox) {
        this.compareBoxId = compareBox.getId();
    }
}
