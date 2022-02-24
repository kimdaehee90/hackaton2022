package com.example.gaegizo.domain.compareBox.service;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.dto.request.CompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.compareBox.mapper.CompareBoxMapper;
import com.example.gaegizo.domain.compareBox.repository.CompareBoxRepository;
import com.example.gaegizo.domain.interesetJob.domain.InterestJob;
import com.example.gaegizo.domain.interesetJob.repository.InterestJobRepository;
import com.example.gaegizo.domain.user.domain.User;
import com.example.gaegizo.domain.user.repository.UserRepository;
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
    private final UserRepository userRepository;

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

    public void saveCompareBox(CompareBoxRequestDto compareBoxRequestDto) {

        CompareBox result = compareBoxMapper.saveCompareBox(compareBoxRequestDto);

        compareBoxRepository.save(result);
    }


    public void test(){
        Optional<InterestJob> interestJob = interestJobRepository.findByJobNumber("42349073");
        interestJob.get().setSalary("4000");
        interestJobRepository.save(interestJob.get());
    }

}
