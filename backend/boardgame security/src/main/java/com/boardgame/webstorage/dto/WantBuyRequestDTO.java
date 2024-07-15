package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.WantBuyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WantBuyRequestDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private Integer photoid;

    public WantBuyRequestDTO(WantBuyEntity wantBuyEntity) {
        this.userid = wantBuyEntity.getUserid();
        this.gameid = wantBuyEntity.getGameid();
        this.photoid = wantBuyEntity.getPhotoid();
    }
}
