package com.example.gaegizo.domain.compareBox.domain;

import com.example.gaegizo.domain.interesetJob.domain.InterestJob;
import com.example.gaegizo.domain.memo.domain.Memo;
import com.example.gaegizo.domain.user.domain.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.gaegizo.domain.interesetJob.domain.InterestJob.InterestJob;
import com.example.gaegizo.domain.user.domain.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "compareBox")
public class CompareBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compare_box_id")
    private Long id;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memo_id")
    private Memo memo;

    @Builder
    public CompareBox(String jobNumber1,String jobNumber2, String jobNumber3){
        this.jobNumber1 = jobNumber1;
        this.jobNumber2 = jobNumber2;
        this.jobNumber3 = jobNumber3;
    }
}
