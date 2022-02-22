package com.example.gaegizo.interesetJob.controller;

import com.example.gaegizo.interesetJob.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CallApi {

    private static final String KEY = "BDGzJGe6BHlD6WbYyYAOYUIcjxlt2nCfoyHkxIwNzLGN4eSSa";

    private final ApiService apiService;

    @PostMapping("/interestJob")
    public String callApi(@RequestBody String/* dto*/ id) throws IOException {
        System.out.println("id = " + id);
        StringBuilder result = new StringBuilder();
        String urlStr = "https://oapi.saramin.co.kr/job-search?access-key="+KEY+"&id="+id;

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
        System.out.println("result = " + result);
        return result.toString();
    }
}
