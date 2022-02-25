package com.example.gaegizo.domain.compareBox.domain;

import com.example.gaegizo.domain.interesetJob.domain.InterestJob;

import com.example.gaegizo.domain.memo.domain.Memo;
import com.example.gaegizo.domain.user.domain.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class CompareBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boxName;
    private String jobNumber1;
    private String jobNumber2;
    private String jobNumber3;

    @JsonBackReference
    @OneToMany(mappedBy = "compareBox",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InterestJob> interestJob = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @OneToOne(mappedBy = "compareBox", cascade = CascadeType.ALL)
    private Memo memo;

    @Builder
    public CompareBox(User user,String boxName,String jobNumber1,String jobNumber2, String jobNumber3){
        this.user = user;
        this.boxName = boxName;
        this.jobNumber1 = jobNumber1;
        this.jobNumber2 = jobNumber2;
        this.jobNumber3 = jobNumber3;
    }

    @Builder
    public void updateCompareBox(String boxName, String jobNumber1, String jobNumber2, String jobNumber3){
        this.boxName = boxName;
        this.jobNumber1 = jobNumber1;
        this.jobNumber2 = jobNumber2;
        this.jobNumber3 = jobNumber3;
    }

}
