package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.*;
import com.boardgame.webstorage.service.ListGameExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/listgameexchange/")
public class ListGameExchangeController {

    private final ListGameExchangeService listGameExchangeService;

    public ListGameExchangeController(ListGameExchangeService listGameExchangeService) {
        this.listGameExchangeService = listGameExchangeService;
    }

    @GetMapping(value = "/allrows")
    public ResponseEntity<List<ListGameExchangeResponseDTO>> getAllRows() {
        return ResponseEntity.ok(listGameExchangeService.getAllListGameExchanges());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<ListGameExchangeResponseDTO>> getListGameExchangeByExchangeId(@PathVariable("id") int id) {
        return ResponseEntity.ok(listGameExchangeService.getListGameExchangeByExchangeId(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createListGameExchange(@RequestBody ListGameExchangeRequestDTO body) {
        return ResponseEntity.ok(listGameExchangeService.createListGameExchange(body.getExchangeid(),body.getGameid()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ListGameExchangeResponseDTO> deleteListGameExchange(@PathVariable("id") int id) {
        return ResponseEntity.ok(listGameExchangeService.deleteListGameExchange(id));
    }
}
