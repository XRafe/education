package org.education.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stage {

    @Id
    @SequenceGenerator(name = "seq_stage_id",
            sequenceName = "seq_stage_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_stage_id")
    private Integer id;

    private String title;

    private String info;

    private String data;

    private String type;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "module_id", insertable = false, updatable = false)
    private Module module;

    @Column(name = "module_id")
    private Integer moduleId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<StageResult> stageResults;

    public Stage(String title, String info, String data, String type, Integer score, Integer moduleId) {
        this.title = title;
        this.info = info;
        this.data = data;
        this.type = type;
        this.score = score;
        this.moduleId = moduleId;
    }
}
