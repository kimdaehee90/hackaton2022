package com.example.gaegizo.domain.compareBox.mapper;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.dto.request.CompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.interesetJob.domain.InterestJob;
import com.example.gaegizo.domain.interesetJob.repository.InterestJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CompareBoxMapper {

    private final InterestJobRepository interestJobRepository;

    public CompareBoxResponseDto getInterestJob(String jobNunber){
        Optional<InterestJob> interestJob = interestJobRepository.findByjobNumber(jobNunber);

        return new CompareBoxResponseDto(
                interestJob.get().getCompanyName(),
                interestJob.get().getCareer(),
                interestJob.get().getRegion(),
                interestJob.get().getSalary(),
                interestJob.get().getAverageSalary(),
                interestJob.get().getJob(),
                interestJob.get().getSectors(),
                interestJob.get().getWorkType(),
                interestJob.get().getPreferentialTreatment(),
                interestJob.get().getWelfare(),
                interestJob.get().getStatistics(),
                interestJob.get().getJobNumber(),
                interestJob.get().getTitle(),
                interestJob.get().getEducation(),
                interestJob.get().getDeadline()
        );

    }
    public CompareBox saveCompareBox(CompareBoxRequestDto compareBoxRequestDto){
        return new CompareBox(
                compareBoxRequestDto.getUserId(),
                compareBoxRequestDto.getBoxName(),
                compareBoxRequestDto.getJobNumber1(),
                compareBoxRequestDto.getJobNumber2(),
                compareBoxRequestDto.getJobNumber3()
        );

    }
}
