package com.example.gaegizo.domain.compareBox.mapper;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.dto.request.CompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.interesetJob.domain.InterestJob;
import com.example.gaegizo.domain.interesetJob.repository.InterestJobRepository;
import com.example.gaegizo.domain.user.domain.User;
import com.example.gaegizo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CompareBoxMapper {

    private final InterestJobRepository interestJobRepository;
    private final UserRepository userRepository;

    public CompareBoxResponseDto getInterestJob(String jobNumber){
        InterestJob interestJob = interestJobRepository.findByJobNumber(jobNumber).orElseThrow(
                () -> new NullPointerException("공고 번호가 잘못 되었습니다. ")
        );

        return new CompareBoxResponseDto(
                interestJob.getCompanyName(),
                interestJob.getCareer(),
                interestJob.getRegion(),
                interestJob.getSalary(),
                interestJob.getAverageSalary(),
                interestJob.getJob(),
                interestJob.getSectors(),
                interestJob.getWorkType(),
                interestJob.getPreferentialTreatment(),
                interestJob.getWelfare(),
                interestJob.getStatistics(),
                interestJob.getJobNumber(),
                interestJob.getTitle(),
                interestJob.getEducation(),
                interestJob.getDeadline()
        );

    }
    public CompareBox saveCompareBox(CompareBoxRequestDto compareBoxRequestDto){

        User user = userRepository.findById(compareBoxRequestDto.getUserId()).orElseThrow(
                () -> new NullPointerException("없는 유저입니다. ")
        );
        return new CompareBox(
                user,
                compareBoxRequestDto.getBoxName(),
                compareBoxRequestDto.getJobNumber1(),
                compareBoxRequestDto.getJobNumber2(),
                compareBoxRequestDto.getJobNumber3()
        );

    }
}
