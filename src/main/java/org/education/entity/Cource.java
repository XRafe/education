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

    private Integer rating;

    private String direction;

    @ManyToOne
    @JoinColumn(name = "creator_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "creator_id")
    private Integer creatorId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Module> modules;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserCources> userCources;

    public Cource(String title, String info, String imageUrl, String usersCount,
                  Integer rating, String direction, Integer creatorId) {
        this.title = title;
        this.info = info;
        this.imageUrl = imageUrl;
        this.usersCount = usersCount;
        this.rating = rating;
        this.direction = direction;
        this.creatorId = creatorId;
    }
}
