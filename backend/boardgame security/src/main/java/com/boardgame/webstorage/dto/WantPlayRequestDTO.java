package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.WantPlayEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WantPlayRequestDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private String photoLink;
    private Integer photoid;
    private String game;

    public WantPlayRequestDTO(WantPlayEntity wantPlayEntity) {
        this.userid = wantPlayEntity.getUserid();
        this.gameid = wantPlayEntity.getGameid();
        this.photoid = wantPlayEntity.getPhotoid();
        this.photoLink = wantPlayEntity.getPhoto().getLink();
        this.game = wantPlayEntity.getBoardgame().getNameEnglish();
    }

}
