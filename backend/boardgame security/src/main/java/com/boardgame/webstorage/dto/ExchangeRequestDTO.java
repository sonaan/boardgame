package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.ExchangeEntity;
import com.boardgame.webstorage.entity.WantBuyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRequestDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private String photoLink;
    private Integer photoid;
    private String game;

    public ExchangeRequestDTO(ExchangeEntity exchangeEntity) {
        this.userid = exchangeEntity.getUserid();
        this.gameid = exchangeEntity.getGameid();
        this.photoid = exchangeEntity.getPhotoid();
        this.photoLink = exchangeEntity.getPhoto().getLink();
        this.game = exchangeEntity.getBoardgame().getNameEnglish();
    }

}
