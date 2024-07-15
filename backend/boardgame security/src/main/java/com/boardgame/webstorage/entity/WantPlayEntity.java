package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "want_play", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class WantPlayEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "userid")
    private Integer userid;
    @Basic
    @Column(name = "gameid")
    private Integer gameid;

    @Basic
    @Column(name = "photoid")
    private Integer photoid;

    public WantPlayEntity(Integer userid, Integer gameid, Integer photoid) {
        this.userid = userid;
        this.gameid = gameid;
        this.photoid = photoid;
    }

    @ManyToOne
    @JoinColumn(name = "gameid", insertable = false, updatable = false)
    private BoardgameEntity boardgame;

    @ManyToOne
    @JoinColumn(name = "photoid", insertable = false, updatable = false)
    private PhotosEntity photo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WantPlayEntity that = (WantPlayEntity) o;
        return id == that.id && Objects.equals(userid, that.userid) && Objects.equals(gameid, that.gameid) && Objects.equals(photoid, that.photoid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, gameid, photoid);
    }
}
