package com.example.gaegizo.domain.interesetJob.domain;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.user.domain.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InterestJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String career;

    private String region;

    private String salary;

    private String averageSalary;

    private String job; //직무

    private String sectors; //업무

    private String workType; //근무형태

    private String preferentialTreatment; //우대사항

    private String welfare;

    private Long statistics;

    private String jobNumber; //공고 번호

    private String title;

    private String education;

    private String deadline;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_ID")
    private User user;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "compareBox_id")
    private CompareBox compareBox;

    public InterestJob update(String title, String job, String salary) {
        this.title = title;
        this.job = job;
        this.salary = salary;
        return this;
    }
}
