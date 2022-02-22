package com.example.gaegizo.domain.memo.domain;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "memo_id")

    private Long id;

    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compare_box")
    private CompareBox compareBox;

    public Long update(String content) {
        this.content = content;
        return id;
    }
}
