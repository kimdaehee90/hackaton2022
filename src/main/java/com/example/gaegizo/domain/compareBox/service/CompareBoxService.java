package com.example.gaegizo.domain.compareBox.service;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.dto.request.CompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.request.UpdateCompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxListReponseDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.compareBox.mapper.CompareBoxMapper;
import com.example.gaegizo.domain.compareBox.repository.CompareBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompareBoxService {

    private final CompareBoxRepository compareBoxRepository;
    private final CompareBoxMapper compareBoxMapper;

    @Transactional
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

    @Transactional
    public CompareBoxResponseDto getAnnouncement(String jobNumber) {
        CompareBoxResponseDto compareBoxResponseDto = compareBoxMapper.getInterestJob(jobNumber);
        return compareBoxResponseDto;
    }

    @Transactional
    public void saveCompareBox(CompareBoxRequestDto compareBoxRequestDto) {
        CompareBox result = compareBoxMapper.saveCompareBox(compareBoxRequestDto);
        compareBoxRepository.save(result);
    }


    @Transactional
    public CompareBoxListReponseDto getComepareBox(Long userId){

        CompareBoxListReponseDto result = compareBoxMapper.getCompareBoxList(userId);

        return result;
    }

    @Transactional
    public void updateCompareBox(UpdateCompareBoxRequestDto updateCompareBoxRequestDto) {
        CompareBox compareBox = compareBoxMapper.updateCompareBox(updateCompareBoxRequestDto);
        compareBoxRepository.save(compareBox);
    }

    public void deleteCompareBox(Long comapareBoxId) {
        CompareBox compareBox = compareBoxMapper.deleteCompareBox(comapareBoxId);
        compareBoxRepository.delete(compareBox);
    }
}
