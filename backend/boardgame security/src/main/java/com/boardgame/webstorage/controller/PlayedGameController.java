package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.*;
import com.boardgame.webstorage.service.PlayedGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/playedgame/")
public class PlayedGameController {

    private final PlayedGameService playedGameService;

    public PlayedGameController(PlayedGameService playedGameService) {
        this.playedGameService = playedGameService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<PlayedGameResponseDTO>> getPlayedGameByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(playedGameService.getPlayedGameByUserId(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createPlayedGame(@RequestBody PlayedGameRequestDTO body) {
        return ResponseEntity.ok(playedGameService.createPlayedGame(body.getUserid(),body.getGameid(), body.getPhotoid()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PlayedGameResponseDTO> deletePlayedGame(@PathVariable("id") int id) {
        return ResponseEntity.ok(playedGameService.deletePlayedGame(id));
    }

    @GetMapping(value = "/gameexist/{userid}/{gameid}")
    public ResponseEntity<PlayedGameResponseDTO> existGameByUserId(@PathVariable("userid") int userid, @PathVariable("gameid") int gameid) {
        return ResponseEntity.ok(playedGameService.existGameByUserId(userid,gameid));
    }
}
