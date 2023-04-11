package org.education.entity;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @SequenceGenerator(name = "seq_message_id",
            sequenceName = "seq_message_id_generator",
            initialValue = 0, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_message_id")
    private Integer id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "chat_id", insertable = false, updatable = false)
    private Chat chat;

    @Column(name = "chat_id")
    private Integer chatId;
}
