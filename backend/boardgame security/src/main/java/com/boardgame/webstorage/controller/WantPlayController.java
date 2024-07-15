package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.WantPlayRequestDTO;
import com.boardgame.webstorage.dto.WantPlayResponseDTO;
import com.boardgame.webstorage.service.WantPlayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wantplay/")
public class WantPlayController {

    private final WantPlayService wantPlayService;

    public WantPlayController(WantPlayService wantPlayService) {
        this.wantPlayService = wantPlayService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<WantPlayResponseDTO>> getWantPlayByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(wantPlayService.getWantPlayByUserId(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createWantPlay(@RequestBody WantPlayRequestDTO body) {
        return ResponseEntity.ok(wantPlayService.createWantPlay(body.getUserid(),body.getGameid(),body.getPhotoid()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<WantPlayResponseDTO> deleteWantPlay(@PathVariable("id") int id) {
        return ResponseEntity.ok(wantPlayService.deleteWantPlay(id));
    }

    @GetMapping(value = "/gameexist/{userid}/{gameid}")
    public ResponseEntity<WantPlayResponseDTO> existGameByUserId(@PathVariable("userid") int userid, @PathVariable("gameid") int gameid) {
        return ResponseEntity.ok(wantPlayService.existGameByUserId(userid,gameid));
    }
}
