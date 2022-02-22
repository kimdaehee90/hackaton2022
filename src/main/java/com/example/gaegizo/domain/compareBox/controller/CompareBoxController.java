package com.example.gaegizo.domain.compareBox.controller;

import com.example.gaegizo.domain.compareBox.dto.request.CompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.compareBox.service.CompareBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompareBoxController {
    public final CompareBoxService compareBoxService;

    @GetMapping("/api/compare")
    public List<CompareBoxResponseDto> compare(@RequestParam String jobNumber1,@RequestParam String jobNumber2,@RequestParam String jobNumber3){

        List<CompareBoxResponseDto> responseDtoList = compareBoxService.getCompareList(jobNumber1,jobNumber2,jobNumber3);
        return responseDtoList;
    }


    @GetMapping("/api/announcement")
    public CompareBoxResponseDto Announcement(@RequestParam String jobNumber){
        CompareBoxResponseDto response = compareBoxService.getAnnouncement(jobNumber);
        return response;
    }

    @PostMapping("/api/compareBox")
    public void compareBox(@RequestBody CompareBoxRequestDto compareBoxRequestDto){

        compareBoxService.saveCompareBox(compareBoxRequestDto);
    }
    @GetMapping("/api/test")
    public void test(){
        compareBoxService.test();
    }


}
