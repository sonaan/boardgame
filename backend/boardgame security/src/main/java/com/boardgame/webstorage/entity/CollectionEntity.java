package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "collection", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class CollectionEntity {
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

    public CollectionEntity(Integer userid, Integer gameid, Integer photoid) {
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

}
