package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.SellEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellRequestDTO {
    private int id;
    private Integer userid;
    private Integer gameid;

    private String price;

    public SellRequestDTO(SellEntity sellEntity) {
        userid = sellEntity.getUserid();
        gameid = sellEntity.getGameid();
        price = sellEntity.getPrice();
    }

}
