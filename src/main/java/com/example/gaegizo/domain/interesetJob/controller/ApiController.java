package com.example.gaegizo.domain.interesetJob.controller;

import com.example.gaegizo.domain.interesetJob.dto.request.InterestJobRequest;
import com.example.gaegizo.domain.interesetJob.dto.response.InterestJobResponse;
import com.example.gaegizo.domain.interesetJob.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ApiController {

    private static final String KEY = "BDGzJGe6BHlD6WbYyYAOYUIcjxlt2nCfoyHkxIwNzLGN4eSSa";

    private final ApiService apiService;

    @PostMapping("/interestJob")
    public String callApi(@RequestBody InterestJobRequest id) throws IOException {
        log.info("id = {}", id.getId());
        StringBuilder result = new StringBuilder();
        String urlStr = "https://oapi.saramin.co.kr/job-search?access-key=" + KEY + "&id=" + id.getId();

        URL url = new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br;

        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        String returnLine;

        while ((returnLine = br.readLine()) != null) {
            result.append(returnLine + "\n\r");
        }

        urlConnection.disconnect();
        apiService.saveApi(result.toString());
        log.info("result = {}", result);
        return result.toString();
    }

    @GetMapping("/interestJob/list")
    public InterestJobResponse getInterestJobList() {
        return new InterestJobResponse(apiService.getInterestJobList());
    }
}
