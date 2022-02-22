package com.example.gaegizo.interesetJob.domain.InterestJob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class InterestJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String career;

    private String region;

    private String salary;

    private Long averageSalary;

    private String job; //직무

    private String sectors; //업무

    private String workType; //근무형태

    private String preferentialTreatment; //우대사항

    private String welfare;

    private Long statistics;

    private String jobNumber;

    private String title;

    private String Education;

    public InterestJob update(String region, String job, String salary) {
        this.region = region;
        this.job = job;
        this.salary = salary;
        return this;
    }
}
