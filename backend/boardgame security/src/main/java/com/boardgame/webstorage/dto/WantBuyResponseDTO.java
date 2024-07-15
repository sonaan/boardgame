package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.WantBuyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WantBuyResponseDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private Integer photoid;
    private String photoLink;
    private String game;

    public WantBuyResponseDTO(WantBuyEntity wantBuyEntity) {
        id = wantBuyEntity.getId();
        userid = wantBuyEntity.getUserid();
        gameid = wantBuyEntity.getGameid();
        photoid = wantBuyEntity.getPhotoid();
        photoLink = wantBuyEntity.getPhoto().getLink();
        game = wantBuyEntity.getBoardgame().getNameEnglish();
    }

}
