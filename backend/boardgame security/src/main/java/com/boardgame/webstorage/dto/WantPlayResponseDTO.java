package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.WantPlayEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WantPlayResponseDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private Integer photoid;
    private String photoLink;
    private String game;

    public WantPlayResponseDTO(WantPlayEntity wantPlayEntity) {
        id = wantPlayEntity.getId();
        userid = wantPlayEntity.getUserid();
        gameid = wantPlayEntity.getGameid();
        game = wantPlayEntity.getBoardgame().getNameRussian();
        photoid = wantPlayEntity.getPhotoid();
        photoLink = wantPlayEntity.getPhoto().getLink();
    }

}
