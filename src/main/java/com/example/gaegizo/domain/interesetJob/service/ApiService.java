package com.example.gaegizo.domain.interesetJob.service;

import com.example.gaegizo.domain.interesetJob.domain.InterestJob;
import com.example.gaegizo.domain.interesetJob.repository.InterestJobRepository;
import com.example.gaegizo.domain.interesetJob.dto.InterestJobDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
                JSONObject company = (JSONObject) jObj.get("company");
                JSONObject companyDetail = (JSONObject) company.get("detail");
                JSONObject position = (JSONObject) jObj.get("position");
                JSONObject industry = (JSONObject) position.get("industry");
                JSONObject salary = (JSONObject) jObj.get("salary");

                InterestJob interestJob = interestJobRepository.findByJobNumber(jObj.get("id").toString())
                        .map(entity -> entity.update(position.get("title").toString(), industry.get("name").toString(), salary.get("name").toString()))
                        .orElse(InterestJob.builder()
                                .companyName(companyDetail.get("name").toString())
                                .title(position.get("title").toString())
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

    public List<InterestJobDto> getInterestJobList() {
        List<InterestJob> interestJobList = interestJobRepository.findAll();
        return interestJobList.stream().map(InterestJobDto::from).collect(Collectors.toList());
    }
}
