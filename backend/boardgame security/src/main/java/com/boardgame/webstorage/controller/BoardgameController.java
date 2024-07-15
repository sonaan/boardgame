package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.BoardgameRequestDTO;
import com.boardgame.webstorage.dto.BoardgameResponseDTO;
import com.boardgame.webstorage.service.BoardgameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/boardgame/")
public class BoardgameController {

    private final BoardgameService boardgameService;

    public BoardgameController(BoardgameService boardgameService) {
        this.boardgameService = boardgameService;
    }

    @GetMapping(value = "/allrows")
    public ResponseEntity<List<BoardgameResponseDTO>> getAllRows() {
        return ResponseEntity.ok(boardgameService.getAllBoardgames());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BoardgameResponseDTO> getBoardgameById(@PathVariable("id") int id) {
        return ResponseEntity.ok(boardgameService.getBoardgameById(id));
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<List<BoardgameResponseDTO>> getBoardgameByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(boardgameService.getBoardgameByName(name));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createBoardgame(@RequestBody BoardgameRequestDTO body) {
        return ResponseEntity.ok(boardgameService.createBoardgame(body.getNameEnglish(),body.getNameRussian(),body.getAuthor(),body.getDesigner(),body.getPublishingHouse(),body.getIssuiYear(),body.getGenre(),body.getNumberPlayers(),
                body.getRecommendedNumberPlayers(),body.getAge(),body.getPartyTime(),body.getBggRating(),body.getDescription(),body.getPhotoid()));
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<BoardgameResponseDTO> updateBoardgame(@RequestBody BoardgameRequestDTO body) {
        return ResponseEntity.ok(boardgameService.updateBoardgame(body.getId(),body.getNameEnglish(),body.getNameRussian(),body.getAuthor(),body.getDesigner(),body.getPublishingHouse(),body.getIssuiYear(),body.getGenre(),body.getNumberPlayers(),
                body.getRecommendedNumberPlayers(),body.getAge(),body.getPartyTime(),body.getBggRating(),body.getDescription(),body.getPhotoid()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BoardgameResponseDTO> deleteBoardgame(@PathVariable("id") int id) {
        return ResponseEntity.ok(boardgameService.deleteBoardgame(id));
    }
}
