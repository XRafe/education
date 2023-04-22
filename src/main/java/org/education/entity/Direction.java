package org.education.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Direction {

    @Id
    @SequenceGenerator(name = "seq_direction_id",
            sequenceName = "seq_direction_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_direction_id")
    private Integer id;

    private String name;
}
