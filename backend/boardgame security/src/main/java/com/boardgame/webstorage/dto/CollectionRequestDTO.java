package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.CollectionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionRequestDTO {
    private int id;
    private Integer userid;
    private Integer gameid;
    private Integer photoid;

    public CollectionRequestDTO(CollectionEntity collectionEntity) {
        this.userid = collectionEntity.getUserid();
        this.gameid = collectionEntity.getGameid();
        this.photoid = collectionEntity.getPhotoid();
    }
}
