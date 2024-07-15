package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.PlayedGameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayedGameResponseDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private Integer photoid;
    private String photoLink;
    private String game;

    public PlayedGameResponseDTO(PlayedGameEntity playedGameEntity) {
        id = playedGameEntity.getId();
        userid = playedGameEntity.getUserid();
        gameid = playedGameEntity.getGameid();
        game = playedGameEntity.getBoardgame().getNameRussian();
        photoid = playedGameEntity.getPhotoid();
        photoLink = playedGameEntity.getPhoto().getLink();
    }

}
