package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "friends", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class FriendEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "userid1")
    private Integer userid1;
    @Basic
    @Column(name = "userid2")
    private Integer userid2;

    public FriendEntity(Integer userid1, Integer userid2) {
        this.userid1 = userid1;
        this.userid2 = userid2;
    }

    @ManyToOne
    @JoinColumn(name = "userid1", insertable = false, updatable = false)
    private UserEntity user1;

    @ManyToOne
    @JoinColumn(name = "userid2", insertable = false, updatable = false)
    private UserEntity user2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendEntity that = (FriendEntity) o;
        return id == that.id && Objects.equals(userid1, that.userid1) && Objects.equals(userid2, that.userid2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid1, userid2);
    }
}
