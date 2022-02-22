package com.example.gaegizo.domain.compareBox.service;

import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.compareBox.repository.CompareBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompareBoxService {
    private final CompareBoxRepository compareBoxRepository;

    public CompareBoxResponseDto getCompareList(String jobNumber1, String jobNumber2, String jobNumber3) {

    }
}
