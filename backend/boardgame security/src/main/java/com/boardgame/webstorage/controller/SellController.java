package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.SellRequestDTO;
import com.boardgame.webstorage.dto.SellResponseDTO;
import com.boardgame.webstorage.service.SellService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sell/")
public class SellController {

    private final SellService sellService;

    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<SellResponseDTO>> getSellByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(sellService.getSellByUserId(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createSell(@RequestBody SellRequestDTO body) {
        return ResponseEntity.ok(sellService.createSell(body.getUserid(),body.getGameid(),body.getPrice()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SellResponseDTO> deleteSell(@PathVariable("id") int id) {
        return ResponseEntity.ok(sellService.deleteSell(id));
    }
}
