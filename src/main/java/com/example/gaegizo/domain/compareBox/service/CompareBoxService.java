package com.example.gaegizo.domain.compareBox.service;

import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.compareBox.mapper.CompareBoxMapper;
import com.example.gaegizo.domain.compareBox.repository.CompareBoxRepository;
import com.example.gaegizo.domain.interesetJob.domain.InterestJob;
import com.example.gaegizo.domain.interesetJob.repository.InterestJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompareBoxService {
    private final CompareBoxRepository compareBoxRepository;
    private final InterestJobRepository interestJobRepository;
    private final CompareBoxMapper compareBoxMapper;

    public List<CompareBoxResponseDto> getCompareList(String jobNumber1, String jobNumber2, String jobNumber3) {
        CompareBoxResponseDto compareBoxResponseDto1 = compareBoxMapper.getInterestJob(jobNumber1);
        CompareBoxResponseDto compareBoxResponseDto2 = compareBoxMapper.getInterestJob(jobNumber2);
        CompareBoxResponseDto compareBoxResponseDto3 = compareBoxMapper.getInterestJob(jobNumber3);

        List<CompareBoxResponseDto> result = new ArrayList<>();
        result.add(compareBoxResponseDto1);
        result.add(compareBoxResponseDto2);
        result.add(compareBoxResponseDto3);

        return result;

    }

    public CompareBoxResponseDto getAnnouncement(String jobNumber) {
        CompareBoxResponseDto compareBoxResponseDto = compareBoxMapper.getInterestJob(jobNumber);
        return compareBoxResponseDto;
    }
}
