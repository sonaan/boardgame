package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.*;
import com.boardgame.webstorage.service.WantBuyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wantbuy/")
public class WantBuyController {

    private final WantBuyService wantBuyService;

    public WantBuyController(WantBuyService wantBuyService) {
        this.wantBuyService = wantBuyService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<WantBuyResponseDTO>> getWantBuyByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(wantBuyService.getWantBuyByUserId(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createWantBuy(@RequestBody WantBuyRequestDTO body) {
        return ResponseEntity.ok(wantBuyService.createWantBuy(body.getUserid(),body.getGameid(),body.getPhotoid()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<WantBuyResponseDTO> deleteWantBuy(@PathVariable("id") int id) {
        return ResponseEntity.ok(wantBuyService.deleteWantBuy(id));
    }

    @GetMapping(value = "/gameexist/{userid}/{gameid}")
    public ResponseEntity<WantBuyResponseDTO> existGameByUserId(@PathVariable("userid") int userid, @PathVariable("gameid") int gameid) {
        return ResponseEntity.ok(wantBuyService.existGameByUserId(userid,gameid));
    }
}
