package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.SellEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellResponseDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private String game;

    private String price;

    public SellResponseDTO(SellEntity sellEntity) {
        id = sellEntity.getId();
        userid = sellEntity.getUserid();
        gameid = sellEntity.getGameid();
        game = sellEntity.getBoardgame().getNameRussian();
        price = sellEntity.getPrice();
    }

}
