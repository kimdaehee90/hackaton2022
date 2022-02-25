package com.example.gaegizo.domain.compareBox.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompareBoxRequestDto {

    private Long compareBoxId;
    private String boxName;
    private String jobNumber1;
    private String jobNumber2;
    private String jobNumber3;
}
