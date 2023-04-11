package org.education.entity;

import jakarta.persistence.*;

@Entity
public class Module {

    @Id
    @SequenceGenerator(name = "seq_module_id",
            sequenceName = "seq_module_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_module_id")
    private Integer id;

    private String title;

    private String info;

    private String score;

    @ManyToOne
    @JoinColumn(name = "cource_id", insertable = false, updatable = false)
    private Cource cource;

    @Column(name = "cource_id")
    private Integer courceId;
}
