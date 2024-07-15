package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.CollectionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionResponseDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private Integer photoid;
    private String photoLink;
    private String game;

    public CollectionResponseDTO(CollectionEntity collectionEntity) {
        id = collectionEntity.getId();
        userid = collectionEntity.getUserid();
        gameid = collectionEntity.getGameid();
        photoid = collectionEntity.getPhotoid();
        photoLink = collectionEntity.getPhoto().getLink();
        game = collectionEntity.getBoardgame().getNameEnglish();
    }

}
