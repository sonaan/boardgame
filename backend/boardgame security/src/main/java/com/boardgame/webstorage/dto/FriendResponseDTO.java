package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.FriendEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendResponseDTO {
    private int id;
    private Integer userid1;
    private Integer userid2;
    private String login1;
    private String login2;

    public FriendResponseDTO(FriendEntity friendEntity) {
        id = friendEntity.getId();
        userid1 = friendEntity.getUserid1();
        userid2 = friendEntity.getUserid2();
        login1 = friendEntity.getUser1().getLogin();
        login2 = friendEntity.getUser2().getLogin();
    }

}
