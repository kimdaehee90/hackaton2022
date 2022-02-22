package com.example.gaegizo.domain.compareBox.controller;

import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.compareBox.service.CompareBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompareBoxController {
    public final CompareBoxService compareBoxService;

    @GetMapping("/api/compare")
    public List<CompareBoxResponseDto> getcompare(@RequestParam String jobNumber1,@RequestParam String jobNumber2,@RequestParam String jobNumber3){
        System.out.println("1===========================");
        List<CompareBoxResponseDto> responseDtoList = compareBoxService.getCompareList(jobNumber1,jobNumber2,jobNumber3);
        System.out.println("2===========================");
        return responseDtoList;
    }


}
