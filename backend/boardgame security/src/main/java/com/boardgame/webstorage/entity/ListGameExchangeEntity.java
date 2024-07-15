package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "list_game_exchange", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class ListGameExchangeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "exchangeid")
    private Integer exchangeid;
    @Basic
    @Column(name = "gameid")
    private Integer gameid;

    public ListGameExchangeEntity(Integer exchangeid, Integer gameid) {
        this.exchangeid = exchangeid;
        this.gameid = gameid;
    }

    @ManyToOne
    @JoinColumn(name = "gameid", insertable = false, updatable = false)
    private BoardgameEntity boardgame;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListGameExchangeEntity that = (ListGameExchangeEntity) o;
        return id == that.id && Objects.equals(exchangeid, that.exchangeid) && Objects.equals(gameid, that.gameid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exchangeid, gameid);
    }
}
