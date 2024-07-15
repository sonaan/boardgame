package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.RentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentResponseDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private String game;
    private String price;
    private String rentalPeriod;

    public RentResponseDTO(RentEntity rentEntity) {
        id = rentEntity.getId();
        userid = rentEntity.getUserid();
        gameid = rentEntity.getGameid();
        game = rentEntity.getBoardgame().getNameRussian();
        price = rentEntity.getPrice();
        rentalPeriod = rentEntity.getRentalPeriod();
    }

}
