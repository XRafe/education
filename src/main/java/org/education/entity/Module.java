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

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "cource_id", insertable = false, updatable = false)
    private Cource cource;

    @Column(name = "cource_id")
    private Integer courceId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Stage> stages;


    public Module(String title, String info, Integer score, Integer courceId) {
        this.title = title;
        this.info = info;
        this.score = score;
        this.courceId = courceId;
    }
}
