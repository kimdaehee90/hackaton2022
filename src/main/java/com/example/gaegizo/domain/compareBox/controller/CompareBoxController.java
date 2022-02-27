package com.example.gaegizo.domain.compareBox.controller;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.dto.request.CompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.request.UpdateCompareBoxRequestDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxListReponseDto;
import com.example.gaegizo.domain.compareBox.dto.response.CompareBoxResponseDto;
import com.example.gaegizo.domain.compareBox.mapper.CompareBoxMapper;
import com.example.gaegizo.domain.compareBox.service.CompareBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CompareBoxController {

    public final CompareBoxService compareBoxService;
    public final CompareBoxMapper compareBoxMapper;


    @GetMapping("/compare")
    public ResponseEntity<List<CompareBoxResponseDto>> compare(@RequestParam String jobNumber1, @RequestParam String jobNumber2, @RequestParam String jobNumber3){

        List<CompareBoxResponseDto> responseList = compareBoxService.getCompareList(jobNumber1,jobNumber2,jobNumber3);
        return ResponseEntity.ok().body(responseList);
    }


    @GetMapping("/announcement")
    public ResponseEntity<CompareBoxResponseDto> Announcement(@RequestParam String jobNumber){
        CompareBoxResponseDto response = compareBoxService.getAnnouncement(jobNumber);
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/saveCompareBox")
    public ResponseEntity<?> saveCompareBox(@RequestBody CompareBoxRequestDto compareBoxRequestDto){

        compareBoxService.saveCompareBox(compareBoxRequestDto);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/compareBoxList/{userId}")
    public ResponseEntity<CompareBoxListReponseDto> compareBoxList(@PathVariable Long userId){

        CompareBoxListReponseDto compareBox = compareBoxService.getComepareBox(userId);
        return ResponseEntity.ok().body(compareBox);
    }

    @PostMapping("/updateCompareBox")
    public ResponseEntity<?> updateCompareBox(@RequestBody UpdateCompareBoxRequestDto updateCompareBoxRequestDto){
        compareBoxService.updateCompareBox(updateCompareBoxRequestDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/deleteCompareBox/{comapareBoxId}")
    public ResponseEntity<?> deleteComepareBox(@PathVariable Long comapareBoxId){
        compareBoxService.deleteCompareBox(comapareBoxId);
        return ResponseEntity.ok().build();
    }

}

