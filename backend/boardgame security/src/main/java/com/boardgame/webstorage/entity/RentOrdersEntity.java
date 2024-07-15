package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "rent_orders", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class RentOrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "game_ownerid")
    private Integer gameOwnerid;
    @Basic
    @Column(name = "tenantid")
    private Integer tenantid;
    @Basic
    @Column(name = "gameid")
    private Integer gameid;
    @Basic
    @Column(name = "date_begin")
    private Date dateBegin;
    @Basic
    @Column(name = "date_end")
    private Date dateEnd;
    @Basic
    @Column(name = "price")
    private String price;
    @Basic
    @Column(name = "payment_method_id")
    private Integer paymentMethodId;
    @Basic
    @Column(name = "payment_state_id")
    private Integer paymentStateId;
    @Basic
    @Column(name = "order_state_id")
    private Integer orderStateId;

    public RentOrdersEntity(Integer gameOwnerid, Integer tenantid, Integer gameid, Date dateBegin, Date dateEnd, String price, Integer paymentMethodId, Integer paymentStateId, Integer orderStateId) {
        this.gameOwnerid = gameOwnerid;
        this.tenantid = tenantid;
        this.gameid = gameid;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.price = price;
        this.paymentMethodId = paymentMethodId;
        this.paymentStateId = paymentStateId;
        this.orderStateId = orderStateId;
    }

    @ManyToOne
    @JoinColumn(name = "game_ownerid", insertable = false, updatable = false)
    private UserEntity userGameOwner;

    @ManyToOne
    @JoinColumn(name = "tenantid", insertable = false, updatable = false)
    private UserEntity userTenant;

    @ManyToOne
    @JoinColumn(name = "gameid", insertable = false, updatable = false)
    private BoardgameEntity boardgame;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", insertable = false, updatable = false)
    private PaymentMethodEntity paymentMethod;

    @ManyToOne
    @JoinColumn(name = "payment_state_id", insertable = false, updatable = false)
    private PaymentStateEntity paymentState;

    @ManyToOne
    @JoinColumn(name = "order_state_id", insertable = false, updatable = false)
    private OrderStateEntity orderState;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentOrdersEntity that = (RentOrdersEntity) o;
        return id == that.id && Objects.equals(gameOwnerid, that.gameOwnerid) && Objects.equals(tenantid, that.tenantid) && Objects.equals(gameid, that.gameid) && Objects.equals(dateBegin, that.dateBegin) && Objects.equals(dateEnd, that.dateEnd) && Objects.equals(price, that.price) && Objects.equals(paymentMethodId, that.paymentMethodId) && Objects.equals(paymentStateId, that.paymentStateId) && Objects.equals(orderStateId, that.orderStateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameOwnerid, tenantid, gameid, dateBegin, dateEnd, price, paymentMethodId, paymentStateId, orderStateId);
    }
}
