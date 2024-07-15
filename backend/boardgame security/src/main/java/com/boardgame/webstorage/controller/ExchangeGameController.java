package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.*;
import com.boardgame.webstorage.service.ExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/exchange/")
public class ExchangeGameController {

    private final ExchangeService exchangeService;

    public ExchangeGameController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<ExchangeResponseDTO>> getExchangeGameByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(exchangeService.getExchangeByUserId(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createExchangeGame(@RequestBody ExchangeRequestDTO body) {
        return ResponseEntity.ok(exchangeService.createExchange(body.getUserid(),body.getGameid(), body.getPhotoid()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ExchangeResponseDTO> deleteExchangeGame(@PathVariable("id") int id) {
        return ResponseEntity.ok(exchangeService.deleteExchange(id));
    }

    @GetMapping(value = "/gameexist/{userid}/{gameid}")
    public ResponseEntity<ExchangeResponseDTO> existGameByUserId(@PathVariable("userid") int userid, @PathVariable("gameid") int gameid) {
        return ResponseEntity.ok(exchangeService.existGameByUserId(userid,gameid));
    }
}
