package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.PlayedGameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayedGameRequestDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private String photoLink;
    private Integer photoid;
    private String game;

    public PlayedGameRequestDTO(PlayedGameEntity playedGameEntity) {
        this.userid = playedGameEntity.getUserid();
        this.gameid = playedGameEntity.getGameid();
        this.photoid = playedGameEntity.getPhotoid();
        this.photoLink = playedGameEntity.getPhoto().getLink();
        this.game = playedGameEntity.getBoardgame().getNameEnglish();
    }

}
