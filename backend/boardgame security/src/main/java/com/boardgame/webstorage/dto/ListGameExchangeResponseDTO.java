package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.ListGameExchangeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListGameExchangeResponseDTO {
    private int id;
    private Integer exchangeid;
    private Integer gameid;
    private String game;

    public ListGameExchangeResponseDTO(ListGameExchangeEntity listGameExchangeEntity) {
        id = listGameExchangeEntity.getId();
        exchangeid = listGameExchangeEntity.getExchangeid();
        gameid = listGameExchangeEntity.getGameid();
        game = listGameExchangeEntity.getBoardgame().getNameEnglish();
    }

}
