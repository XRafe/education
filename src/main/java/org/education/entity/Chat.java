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
public class Chat {

    @Id
    @SequenceGenerator(name = "seq_chat_id",
            sequenceName = "seq_chat_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_chat_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cource_id", insertable = false, updatable = false)
    private Cource cource;

    @Column(name = "cource_id")
    private Integer courceId;

    @OneToMany(mappedBy = "chat")
    private Set<Message> messages;

    public Chat(Integer courceId) {
        this.courceId = courceId;
    }
}
