package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "purchase_orders", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class PurchaseOrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "sellerid")
    private Integer sellerid;
    @Basic
    @Column(name = "buyerid")
    private Integer buyerid;
    @Basic
    @Column(name = "gameid")
    private Integer gameid;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "price")
    private String price;
    @Basic
    @Column(name = "shipping_method")
    private String shippingMethod;
    @Basic
    @Column(name = "seller_city")
    private String sellerCity;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "photo_link")
    private String photoLink;

    @Basic
    @Column(name = "payment_method_id")
    private Integer paymentMethodId;
    @Basic
    @Column(name = "payment_state_id")
    private Integer paymentStateId;
    @Basic
    @Column(name = "order_state_id")
    private Integer orderStateId;

    public PurchaseOrdersEntity(Integer sellerid, Integer gameid, String sellerCity, String address, String price, String shippingMethod, String description, String photoLink) {
        this.sellerid = sellerid;
        this.gameid = gameid;
        this.address = address;
        this.price = price;
        this.shippingMethod = shippingMethod;
        this.sellerCity = sellerCity;
        this.description = description;
        this.photoLink = photoLink;
    }

    @ManyToOne
    @JoinColumn(name = "sellerid", insertable = false, updatable = false)
    private UserEntity seller;

    @ManyToOne
    @JoinColumn(name = "buyerid", insertable = false, updatable = false)
    private UserEntity buyer;

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
        PurchaseOrdersEntity that = (PurchaseOrdersEntity) o;
        return id == that.id && Objects.equals(sellerid, that.sellerid) && Objects.equals(buyerid, that.buyerid) && Objects.equals(gameid, that.gameid) && Objects.equals(address, that.address) && Objects.equals(price, that.price) && Objects.equals(shippingMethod, that.shippingMethod) && Objects.equals(sellerCity, that.sellerCity) && Objects.equals(paymentMethodId, that.paymentMethodId) && Objects.equals(paymentStateId, that.paymentStateId) && Objects.equals(orderStateId, that.orderStateId) && Objects.equals(seller, that.seller) && Objects.equals(buyer, that.buyer) && Objects.equals(boardgame, that.boardgame) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(paymentState, that.paymentState) && Objects.equals(orderState, that.orderState) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sellerid, buyerid, gameid, address, price, shippingMethod, sellerCity, paymentMethodId, paymentStateId, orderStateId, seller, buyer, boardgame, paymentMethod, paymentState, orderState, description);
    }
}
