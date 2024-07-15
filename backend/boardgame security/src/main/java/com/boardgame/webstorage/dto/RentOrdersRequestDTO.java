package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.RentOrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentOrdersRequestDTO {
    private int id;
    private Integer gameOwnerid;
    private Integer tenantid;
    private Integer gameid;
    private String price;
    private Date dateBegin;
    private Date dateEnd;
    private Integer paymentMethodId;
    private Integer paymentStateId;
    private Integer orderStateId;

    public RentOrdersRequestDTO(RentOrdersEntity rentOrdersEntity) {
        gameOwnerid = rentOrdersEntity.getGameOwnerid();
        tenantid = rentOrdersEntity.getTenantid();
        gameid = rentOrdersEntity.getGameid();
        price = rentOrdersEntity.getPrice();
        dateBegin = rentOrdersEntity.getDateBegin();
        dateEnd = rentOrdersEntity.getDateEnd();
        paymentMethodId = rentOrdersEntity.getPaymentMethodId();
        paymentStateId = rentOrdersEntity.getPaymentStateId();
        orderStateId = rentOrdersEntity.getOrderStateId();
    }
}
