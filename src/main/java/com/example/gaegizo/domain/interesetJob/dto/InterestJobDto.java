package com.example.gaegizo.domain.interesetJob.dto;

import com.example.gaegizo.domain.interesetJob.domain.InterestJob.InterestJob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class InterestJobDto {

    private String jobNumber;

    private String companyName;

    private String title;

    private String career;

    private String education;

    private String workType;

    private String region;

    private String deadline;

    public static InterestJobDto from(InterestJob interestJob) {
        return InterestJobDto.builder()
                .jobNumber(interestJob.getJobNumber())
                .companyName(interestJob.getCompanyName())
                .title(interestJob.getTitle())
                .career(interestJob.getCareer())
                .education(interestJob.getEducation())
                .workType(interestJob.getWorkType())
                .region(interestJob.getRegion())
                .deadline(interestJob.getDeadline())
                .build();
    }
}
