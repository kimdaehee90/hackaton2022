package com.example.gaegizo.domain.memo.domain;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToOne(mappedBy = "memo", cascade = CascadeType.ALL)
    private CompareBox compareBox;
}
