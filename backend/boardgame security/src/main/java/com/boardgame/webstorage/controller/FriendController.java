package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.FriendRequestDTO;
import com.boardgame.webstorage.dto.FriendResponseDTO;
import com.boardgame.webstorage.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/friend/")
public class FriendController {

    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<FriendResponseDTO>> getFriendByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(friendService.getFriendByUserId(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createFriend(@RequestBody FriendRequestDTO body) {
        return ResponseEntity.ok(friendService.createFriend(body.getUserid1(),body.getUserid2()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FriendResponseDTO> deleteFriend(@PathVariable("id") int id) {
        return ResponseEntity.ok(friendService.deleteFriend(id));
    }
}
