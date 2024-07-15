package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sell", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class SellEntity {
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
    @Column(name = "price")
    private String price;

    public SellEntity(Integer userid, Integer gameid, String price) {
        this.userid = userid;
        this.gameid = gameid;
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "gameid", insertable = false, updatable = false)
    private BoardgameEntity boardgame;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellEntity that = (SellEntity) o;
        return id == that.id && Objects.equals(userid, that.userid) && Objects.equals(gameid, that.gameid) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, gameid, price);
    }
}
