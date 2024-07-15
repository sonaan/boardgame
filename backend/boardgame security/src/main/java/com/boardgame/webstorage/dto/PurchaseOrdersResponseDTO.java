package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.PurchaseOrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrdersResponseDTO {
    private int id;
    private Integer sellerid;
    private Integer buyerid;

    private Integer gameid;
    private String price;
    private String address;
    private String sellerCity;
    private String shippingMethod;
    private String description;
    private String photoLink;
    private Integer paymentMethodId;
    private Integer paymentStateId;
    private Integer orderStateId;
    private String seller;
    private String buyer;
    private String game;
    private String paymentMethod;
    private String paymentState;
    private String orderState;



    public PurchaseOrdersResponseDTO(PurchaseOrdersEntity purchaseOrdersEntity) {
        id = purchaseOrdersEntity.getId();
        sellerid = purchaseOrdersEntity.getSellerid();
        buyerid = purchaseOrdersEntity.getBuyerid();
        price = purchaseOrdersEntity.getPrice();
        address = purchaseOrdersEntity.getAddress();
        paymentMethodId = purchaseOrdersEntity.getPaymentMethodId();
        paymentStateId = purchaseOrdersEntity.getPaymentStateId();
        orderStateId = purchaseOrdersEntity.getOrderStateId();
        seller = purchaseOrdersEntity.getSeller().getLogin();
        buyer = purchaseOrdersEntity.getBuyer() == null ? null : purchaseOrdersEntity.getBuyer().getLogin();
        game = purchaseOrdersEntity.getBoardgame().getNameEnglish();
        paymentMethod = purchaseOrdersEntity.getPaymentMethod() == null ? null : purchaseOrdersEntity.getPaymentMethod().getMethod();
        paymentState = purchaseOrdersEntity.getPaymentState() == null ? null : purchaseOrdersEntity.getPaymentState().getState();
        orderState = purchaseOrdersEntity.getOrderState() == null ? null : purchaseOrdersEntity.getOrderState().getMethod();
        sellerCity = purchaseOrdersEntity.getSellerCity();
        shippingMethod = purchaseOrdersEntity.getShippingMethod();
        description = purchaseOrdersEntity.getDescription();
        photoLink = purchaseOrdersEntity.getPhotoLink();
        gameid = purchaseOrdersEntity.getGameid();
    }

}
