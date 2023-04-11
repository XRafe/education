package org.education.entity;

import jakarta.persistence.*;

@Entity
public class Cource {

    @Id
    @SequenceGenerator(name = "seq_cource_id",
            sequenceName = "seq_cource_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_cource_id")
    private Integer id;

    private String title;

    private String info;

    private String imageUrl;

    private String usersCount;

    private String rating;

    private String direction;

    @ManyToOne
    @JoinColumn(name = "creator_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "creator_id")
    private Integer creatorId;
}
