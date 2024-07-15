package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exchange_orders", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class
ExchangeOrdersEntity {
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
    @Basic
    @Column(name = "gameid1")
    private Integer gameid1;
    @Basic
    @Column(name = "gameid2")
    private Integer gameid2;
    @Basic
    @Column(name = "order_state_id")
    private Integer orderStateId;

    @Basic
    @Column(name = "exchanger_city")
    private String exchangerCity;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "description1")
    private String description1;

    @Basic
    @Column(name = "description2")
    private String description2;

    @Basic
    @Column(name = "photo_link1")
    private String photoLink1;

    @Basic
    @Column(name = "photo_link2")
    private String photoLink2;

    @Basic
    @Column(name = "rejection_reason")
    private String rejectionReason;


    @ManyToOne
    @JoinColumn(name = "userid1", insertable = false, updatable = false)
    private UserEntity user1;

    @ManyToOne
    @JoinColumn(name = "userid2", insertable = false, updatable = false)
    private UserEntity user2;

    @ManyToOne
    @JoinColumn(name = "gameid1", insertable = false, updatable = false)
    private BoardgameEntity game1;

    @ManyToOne
    @JoinColumn(name = "gameid2", insertable = false, updatable = false)
    private BoardgameEntity game2;

    @ManyToOne
    @JoinColumn(name = "order_state_id", insertable = false, updatable = false)
    private OrderStateEntity orderState;


    public ExchangeOrdersEntity(Integer userid1, Integer gameid1, String exchangerCity, String address, String description1, String photoLink1) {
        this.userid1 = userid1;
        this.gameid1 = gameid1;
        this.exchangerCity = exchangerCity;
        this.address = address;
        this.description1 = description1;
        this.photoLink1 = photoLink1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExchangeOrdersEntity)) return false;

        ExchangeOrdersEntity that = (ExchangeOrdersEntity) o;

        if (id != that.id) return false;
        if (userid1 != null ? !userid1.equals(that.userid1) : that.userid1 != null) return false;
        if (userid2 != null ? !userid2.equals(that.userid2) : that.userid2 != null) return false;
        if (gameid1 != null ? !gameid1.equals(that.gameid1) : that.gameid1 != null) return false;
        if (gameid2 != null ? !gameid2.equals(that.gameid2) : that.gameid2 != null) return false;
        if (orderStateId != null ? !orderStateId.equals(that.orderStateId) : that.orderStateId != null) return false;
        if (exchangerCity != null ? !exchangerCity.equals(that.exchangerCity) : that.exchangerCity != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (description1 != null ? !description1.equals(that.description1) : that.description1 != null) return false;
        if (description2 != null ? !description2.equals(that.description2) : that.description2 != null) return false;
        if (photoLink1 != null ? !photoLink1.equals(that.photoLink1) : that.photoLink1 != null) return false;
        if (photoLink2 != null ? !photoLink2.equals(that.photoLink2) : that.photoLink2 != null) return false;
        if (rejectionReason != null ? !rejectionReason.equals(that.rejectionReason) : that.rejectionReason != null)
            return false;
        if (user1 != null ? !user1.equals(that.user1) : that.user1 != null) return false;
        if (user2 != null ? !user2.equals(that.user2) : that.user2 != null) return false;
        if (game1 != null ? !game1.equals(that.game1) : that.game1 != null) return false;
        return game2 != null ? game2.equals(that.game2) : that.game2 == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid1 != null ? userid1.hashCode() : 0);
        result = 31 * result + (userid2 != null ? userid2.hashCode() : 0);
        result = 31 * result + (gameid1 != null ? gameid1.hashCode() : 0);
        result = 31 * result + (gameid2 != null ? gameid2.hashCode() : 0);
        result = 31 * result + (orderStateId != null ? orderStateId.hashCode() : 0);
        result = 31 * result + (exchangerCity != null ? exchangerCity.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (description1 != null ? description1.hashCode() : 0);
        result = 31 * result + (description2 != null ? description2.hashCode() : 0);
        result = 31 * result + (photoLink1 != null ? photoLink1.hashCode() : 0);
        result = 31 * result + (photoLink2 != null ? photoLink2.hashCode() : 0);
        result = 31 * result + (rejectionReason != null ? rejectionReason.hashCode() : 0);
        result = 31 * result + (user1 != null ? user1.hashCode() : 0);
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        result = 31 * result + (game1 != null ? game1.hashCode() : 0);
        result = 31 * result + (game2 != null ? game2.hashCode() : 0);
        return result;
    }
}
