package com.example.gaegizo.domain.interesetJob.dto.response;

import com.example.gaegizo.domain.interesetJob.dto.InterestJobDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InterestJobResponse {

    private List<InterestJobDto> data;
}
