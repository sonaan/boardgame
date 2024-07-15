package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.CollectionRequestDTO;
import com.boardgame.webstorage.dto.CollectionResponseDTO;
import com.boardgame.webstorage.service.CollectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/collection/")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<CollectionResponseDTO>> getCollectionByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(collectionService.getCollectionByUserId(id));
    }

    @GetMapping(value = "/gameexist/{userid}/{gameid}")
    public ResponseEntity<CollectionResponseDTO> existGameByUserId(@PathVariable("userid") int userid, @PathVariable("gameid") int gameid) {
        return ResponseEntity.ok(collectionService.existGameByUserId(userid,gameid));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createUser(@RequestBody CollectionRequestDTO body) {
        return ResponseEntity.ok(collectionService.createCollection(body.getUserid(),body.getGameid(),body.getPhotoid()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CollectionResponseDTO> deleteCollection(@PathVariable("id") int id) {
        return ResponseEntity.ok(collectionService.deleteCollection(id));
    }
}
