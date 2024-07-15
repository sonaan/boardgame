package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.ExchangeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeResponseDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private Integer photoid;
    private String photoLink;
    private String game;
    private String user;

    public ExchangeResponseDTO(ExchangeEntity exchangeEntity) {
        id = exchangeEntity.getId();
        userid = exchangeEntity.getUserid();
        gameid = exchangeEntity.getGameid();
        game = exchangeEntity.getBoardgame().getNameEnglish();
        photoid = exchangeEntity.getPhotoid();
        photoLink = exchangeEntity.getPhoto().getLink();
        user = exchangeEntity.getUser().getLogin();
    }

}
