package com.example.gaegizo.domain.compareBox.mapper;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.dto.request.CompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.compareBox.repository.CompareBoxRepository;
import com.example.gaegizo.domain.interesetJob.domain.InterestJob;
import com.example.gaegizo.domain.interesetJob.repository.InterestJobRepository;
import com.example.gaegizo.domain.user.domain.User;
import com.example.gaegizo.domain.user.repository.UserRepository;
import com.example.gaegizo.exception.GaegizoErrorCode;
import com.example.gaegizo.exception.GaegizoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.gaegizo.exception.GaegizoErrorCode.JOB_NUMBER_NOT_FOUND_EXCEPTION;
import static com.example.gaegizo.exception.GaegizoErrorCode.USER_NOT_FOUND_EXCEPTION;

@Component
@RequiredArgsConstructor
public class CompareBoxMapper {

    private final InterestJobRepository interestJobRepository;
    private final UserRepository userRepository;
    private final CompareBoxRepository compareBoxRepository;

    public CompareBoxResponseDto getInterestJob(String jobNumber){
        InterestJob interestJob = interestJobRepository.findByJobNumber(jobNumber).orElseThrow(
                () -> new GaegizoException(JOB_NUMBER_NOT_FOUND_EXCEPTION)
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
                () -> new GaegizoException(USER_NOT_FOUND_EXCEPTION)
        );
        return new CompareBox(
                user,
                compareBoxRequestDto.getBoxName(),
                compareBoxRequestDto.getJobNumber1(),
                compareBoxRequestDto.getJobNumber2(),
                compareBoxRequestDto.getJobNumber3()
        );

    }
    public CompareBox getCompareBox(CompareBoxRequestDto compareBoxRequestDto){

        CompareBox compareBox = compareBoxRepository.findByUser_Id(compareBoxRequestDto.getUserId()).orElseThrow(
                () -> new GaegizoException(GaegizoErrorCode.COMPARE_BOX_NOT_FOUND)
        );
        return compareBox;
    }
}
