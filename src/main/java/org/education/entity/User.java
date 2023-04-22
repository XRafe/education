package org.education.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "seq_user_id",
            sequenceName = "seq_user_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_user_id")
    private Integer id;

    private String name;

    private String secondName;

    private String email;

    private String password;

    private String info;

    private String status;

    public User(String name, String secondName, String email, String password, String info, String status) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.info = info;
        this.status = status;
    }
}
