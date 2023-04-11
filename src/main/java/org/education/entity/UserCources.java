package org.education.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserCources {

    @Id
    @SequenceGenerator(name = "seq_user_cources_id",
            sequenceName = "seq_user_cources_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_user_cources_id")
    private Integer id;

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

    private Integer scores;

    public UserCources(Integer userId, Integer courceId, Integer scores) {
        this.userId = userId;
        this.courceId = courceId;
        this.scores = scores;
    }
}
