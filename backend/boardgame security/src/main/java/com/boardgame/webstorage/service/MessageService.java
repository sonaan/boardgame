package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.MessageResponseDTO;
import com.boardgame.webstorage.entity.MessageEntity;
import com.boardgame.webstorage.repositories.MessageRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MessageService {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    public List<MessageResponseDTO>  getMessageInboxByUserId(int id) {
        log.debug("getMessageInboxByUserId: " + id);
        return messageRepo.findByUseridReceive(id).stream().map(MessageResponseDTO::new).collect(Collectors.toList());
    }

    public List<MessageResponseDTO>  getMessageSentByUserId(int id) {
        log.debug("getMessageSentByUserId: " + id);
        return messageRepo.findByUseridSend(id).stream().map(MessageResponseDTO::new).collect(Collectors.toList());
    }

    public int createMessage(int userid_send, int userid_receive, String message) {
        MessageEntity messageEntity = new MessageEntity(userid_send,userid_receive,message);
        log.debug("Message creation: " + messageEntity);
        return messageRepo.save(messageEntity).getId();
    }

    public MessageResponseDTO deleteMessage(int id) {
        MessageEntity messageEntity = messageRepo.findById(id).get();
        messageRepo.deleteById(id);
        log.debug("Message with id " + id + " was deleted");
        return new MessageResponseDTO(messageEntity);
    }
}
