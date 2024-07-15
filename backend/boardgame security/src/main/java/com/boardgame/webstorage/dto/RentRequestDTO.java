package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.RentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentRequestDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private String price;
    private String rentalPeriod;

    public RentRequestDTO(RentEntity rentEntity) {
        userid = rentEntity.getUserid();
        gameid = rentEntity.getGameid();
        price = rentEntity.getPrice();
        rentalPeriod = rentEntity.getRentalPeriod();
    }

}
