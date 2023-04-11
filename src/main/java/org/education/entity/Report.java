package org.education.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
public class Report {
    @Id
    @SequenceGenerator(name = "seq_report_id",
            sequenceName = "seq_report_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_report_id")
    private Integer id;

    private String text;

    private Integer rating;

    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "cource_id", insertable = false, updatable = false)
    private Cource cource;

    @Column(name = "cource_id")
    private Integer courceId;

    public Report(String text, Integer rating, Instant createdAt) {
        this.text = text;
        this.rating = rating;
        this.createdAt = createdAt;
    }
}
