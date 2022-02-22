package com.example.gaegizo.domain.compareBox.service;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.dto.request.CompareBoxRequestDto;
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

    public void saveCompareBox(CompareBoxRequestDto compareBoxRequestDto) {

        CompareBox result = compareBoxMapper.saveCompareBox(compareBoxRequestDto);

        compareBoxRepository.save(result);
    }
    public void test(){
        InterestJob interestJob = new InterestJob();
        interestJob.setCompanyName("(주)보미");
        interestJob.setJob("운송·운수·물류");
        interestJob.setCareer("경력 무관");
        interestJob.setDeadline("상시채용");
        interestJob.setJobNumber("42370652");
        interestJob.setEducation("학력 무관");
        interestJob.setAverageSalary(2000L);
        interestJob.setPreferentialTreatment("해당 분야 전공자 및 유경험자 우대");
        interestJob.setWorkType("정규직");
        interestJob.setStatistics(80L);
        interestJob.setSalary("면접 후 결정");
        interestJob.setSectors("IT웹 서비스");
        interestJob.setTitle("이자경수학 아이파크관에서 고등 수학선생님 구인합니다");
        interestJob.setWelfare("4대 보험");
        interestJob.setRegion("서울시 송파구");
        interestJobRepository.save(interestJob);

    }

}
