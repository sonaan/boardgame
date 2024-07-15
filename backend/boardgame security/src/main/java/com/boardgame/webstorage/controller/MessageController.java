package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.MessageRequestDTO;
import com.boardgame.webstorage.dto.MessageResponseDTO;
import com.boardgame.webstorage.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/message/")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/inbox/{id}")
    public ResponseEntity<List<MessageResponseDTO>> getMessageInboxByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(messageService.getMessageInboxByUserId(id));
    }

    @GetMapping(value = "/sent/{id}")
    public ResponseEntity<List<MessageResponseDTO>> getMessageSentByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(messageService.getMessageSentByUserId(id));
    }


    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createMessage(@RequestBody MessageRequestDTO body) {
        return ResponseEntity.ok(messageService.createMessage(body.getUseridSend(),body.getUseridReceive(),body.getMessage()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageResponseDTO> deleteMessage(@PathVariable("id") int id) {
        return ResponseEntity.ok(messageService.deleteMessage(id));
    }
}
