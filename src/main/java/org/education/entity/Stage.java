package org.education.entity;

import jakarta.persistence.*;

@Entity
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

    private String score;

    @ManyToOne
    @JoinColumn(name = "module_id", insertable = false, updatable = false)
    private Module module;

    @Column(name = "module_id")
    private Integer moduleId;

}
