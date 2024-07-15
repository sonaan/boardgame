package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.FriendEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequestDTO {
    private int id;
    private Integer userid1;
    private Integer userid2;

    public FriendRequestDTO(FriendEntity friendEntity) {
        userid1 = friendEntity.getUserid1();
        userid2 = friendEntity.getUserid2();
    }

}
