package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.PurchaseOrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrdersRequestDTO {
    private int id;
    private Integer sellerid;
    private Integer buyerid;
    private String price;
    private String address;
    private Integer gameid;
    private String sellerCity;
    private String shippingMethod;
    private String description;
    private String photoLink;
    private Integer paymentMethodId;
    private Integer paymentStateId;
    private Integer orderStateId;


    public PurchaseOrdersRequestDTO(PurchaseOrdersEntity purchaseOrdersEntity) {
        sellerid = purchaseOrdersEntity.getSellerid();
        buyerid = purchaseOrdersEntity.getBuyerid();
        price = purchaseOrdersEntity.getPrice();
        address = purchaseOrdersEntity.getAddress();
        gameid = purchaseOrdersEntity.getGameid();
        paymentMethodId = purchaseOrdersEntity.getPaymentMethodId();
        paymentStateId = purchaseOrdersEntity.getPaymentStateId();
        orderStateId = purchaseOrdersEntity.getOrderStateId();
        sellerCity = purchaseOrdersEntity.getSellerCity();
        shippingMethod = purchaseOrdersEntity.getShippingMethod();
        description = purchaseOrdersEntity.getDescription();
        photoLink = purchaseOrdersEntity.getPhotoLink();
    }

}
