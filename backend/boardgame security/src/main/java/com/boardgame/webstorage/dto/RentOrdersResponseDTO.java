package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.RentOrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentOrdersResponseDTO {
    private int id;
    private Integer gameOwnerid;
    private Integer tenantid;
    private String price;
    private Date dateBegin;
    private Date dateEnd;
    private Integer paymentMethodId;
    private Integer paymentStateId;
    private Integer orderStateId;
    private String gameOwner;
    private String tenant;
    private String game;
    private String paymentMethod;
    private String paymentState;
    private String orderState;



    public RentOrdersResponseDTO(RentOrdersEntity rentOrdersEntity) {
        id = rentOrdersEntity.getId();
        gameOwnerid = rentOrdersEntity.getGameOwnerid();
        tenantid = rentOrdersEntity.getTenantid();
        price = rentOrdersEntity.getPrice();
        dateBegin = rentOrdersEntity.getDateBegin();
        dateEnd = rentOrdersEntity.getDateEnd();
        paymentMethodId = rentOrdersEntity.getPaymentMethodId();
        paymentStateId = rentOrdersEntity.getPaymentStateId();
        orderStateId = rentOrdersEntity.getOrderStateId();
        gameOwner = rentOrdersEntity.getUserGameOwner().getLogin();
        tenant = rentOrdersEntity.getUserTenant().getLogin();
        game = rentOrdersEntity.getBoardgame().getNameRussian();
        paymentMethod = rentOrdersEntity.getPaymentMethod().getMethod();
        paymentState = rentOrdersEntity.getPaymentState().getState();
        orderState = rentOrdersEntity.getOrderState().getMethod();
    }

}
