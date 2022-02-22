package com.example.gaegizo.interesetJob.service;

import com.example.gaegizo.interesetJob.domain.InterestJob.InterestJob;
import com.example.gaegizo.interesetJob.domain.InterestJob.InterestJobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiService {

    private final InterestJobRepository interestJobRepository;

    @Transactional
    public void saveApi(String jsonData) {
        try {
            JSONObject jObj;
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonData);
            JSONObject parseResponse = (JSONObject) jsonObj.get("jobs");
            JSONArray array = (JSONArray) parseResponse.get("job");
            log.info("array = {}", array);
            for (int i = 0; i < array.size(); i++) {
                jObj = (JSONObject) array.get(i);
                JSONObject position = (JSONObject) jObj.get("position");
                JSONObject location = (JSONObject) position.get("location");
                JSONObject industry = (JSONObject) position.get("industry");

                JSONObject salary = (JSONObject) jObj.get("salary");
                //Todo: 리팩토링 필요
                InterestJob interestJob = interestJobRepository.findByjobNumber(jObj.get("id").toString())
                        .map(entity -> entity.update(location.get("name").toString(), industry.get("name").toString(), salary.get("name").toString()))
                        .orElse(InterestJob.builder()
                                .region(location.get("name").toString())
                                .job(industry.get("name").toString())
                                .salary(salary.get("name").toString())
                                .jobNumber(jObj.get("id").toString())
                                .build());
                interestJobRepository.save(interestJob);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
