package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.ExchangeOrdersEntity;
import com.boardgame.webstorage.entity.PurchaseOrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeOrdersResponseDTO {
    private int id;
    private Integer userid1;
    private Integer userid2;
    private Integer gameid1;
    private Integer gameid2;
    private Integer orderStateId;
    private String exchangerCity;
    private String address;
    private String description1;
    private String description2;
    private String photoLink1;
    private String photoLink2;
    private String rejectionReason;
    private String user1;
    private String user2;
    private String game1;
    private String game2;
    private String orderState;



    public ExchangeOrdersResponseDTO(ExchangeOrdersEntity exchangeOrdersEntity) {
        id = exchangeOrdersEntity.getId();
        userid1 = exchangeOrdersEntity.getUserid1();
        userid2 = exchangeOrdersEntity.getUserid2();
        gameid1 = exchangeOrdersEntity.getGameid1();
        gameid2 = exchangeOrdersEntity.getGameid2();
        orderStateId = exchangeOrdersEntity.getOrderStateId();
        exchangerCity = exchangeOrdersEntity.getExchangerCity();
        address = exchangeOrdersEntity.getAddress();
        description1 = exchangeOrdersEntity.getDescription1();
        description2 = exchangeOrdersEntity.getDescription2();
        photoLink1 = exchangeOrdersEntity.getPhotoLink1();
        photoLink2 = exchangeOrdersEntity.getPhotoLink2();
        rejectionReason = exchangeOrdersEntity.getRejectionReason();
        user1 = exchangeOrdersEntity.getUser1().getLogin();
        user2 = exchangeOrdersEntity.getUser2() == null ? null : exchangeOrdersEntity.getUser2().getLogin();
        game1 = exchangeOrdersEntity.getGame1().getNameEnglish();
        game2 = exchangeOrdersEntity.getGame2() == null ? null : exchangeOrdersEntity.getGame2().getNameEnglish();
        orderState = exchangeOrdersEntity.getOrderState() == null ? null : exchangeOrdersEntity.getOrderState().getMethod();
    }

}
