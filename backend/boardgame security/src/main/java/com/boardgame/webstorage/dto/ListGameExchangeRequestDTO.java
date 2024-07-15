package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.ListGameExchangeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListGameExchangeRequestDTO {
    private int id;
    private Integer exchangeid;
    private Integer gameid;

    public ListGameExchangeRequestDTO(ListGameExchangeEntity listGameExchangeEntity) {
        exchangeid = listGameExchangeEntity.getExchangeid();
        gameid = listGameExchangeEntity.getGameid();
    }

}
