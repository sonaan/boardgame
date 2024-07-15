package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseDTO {
    private int id;
    private Integer useridSend;
    private Integer useridReceive;
    private String message;
    private String loginSend;
    private String loginReceive;

    public MessageResponseDTO(MessageEntity messageEntity) {
        id = messageEntity.getId();
        useridSend = messageEntity.getUseridSend();
        useridReceive = messageEntity.getUseridReceive();
        loginSend = messageEntity.getUserSend().getLogin();
        loginReceive = messageEntity.getUserReceive().getLogin();
        message = messageEntity.getMessage();
    }

}
