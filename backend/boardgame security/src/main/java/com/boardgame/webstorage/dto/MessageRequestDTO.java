package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestDTO {
    private int id;
    private Integer useridSend;
    private Integer useridReceive;
    private String message;

    public MessageRequestDTO(MessageEntity messageEntity) {
        useridSend = messageEntity.getUseridSend();
        useridReceive = messageEntity.getUseridReceive();
        message = messageEntity.getMessage();
    }

}
