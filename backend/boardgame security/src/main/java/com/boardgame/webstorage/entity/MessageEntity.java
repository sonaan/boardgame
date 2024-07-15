package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "messages", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class MessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "userid1")
    private Integer useridSend;
    @Basic
    @Column(name = "userid2")
    private Integer useridReceive;
    @Basic
    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "userid1", insertable = false, updatable = false)
    private UserEntity userSend;

    @ManyToOne
    @JoinColumn(name = "userid2", insertable = false, updatable = false)
    private UserEntity userReceive;

    public MessageEntity(Integer useridSend, Integer useridReceive, String message) {
        this.useridSend = useridSend;
        this.useridReceive = useridReceive;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return id == that.id && Objects.equals(useridSend, that.useridSend) && Objects.equals(useridReceive, that.useridReceive) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, useridSend, useridReceive, message);
    }
}
