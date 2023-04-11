package org.education.entity;

import jakarta.persistence.*;

@Entity
public class StageResult {

    @Id
    @SequenceGenerator(name = "seq_stage_result_id",
            sequenceName = "seq_stage_result_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_stage_result_id")
    private Integer id;

    private Integer score;

    private String isDone;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "stage_id", insertable = false, updatable = false)
    private Stage stage;

    @Column(name = "stage_id")
    private Integer stageId;


}
