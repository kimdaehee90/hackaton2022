package com.example.gaegizo.interesetJob.dto.response;

import com.example.gaegizo.interesetJob.dto.InterestJobDto;
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
