package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.RentRequestDTO;
import com.boardgame.webstorage.dto.RentResponseDTO;
import com.boardgame.webstorage.service.RentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rent/")
public class RentController {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<RentResponseDTO>> getRentByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(rentService.getRentByUserId(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createRent(@RequestBody RentRequestDTO body) {
        return ResponseEntity.ok(rentService.createRent(body.getUserid(),body.getGameid(),body.getPrice(),body.getRentalPeriod()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<RentResponseDTO> deleteRent(@PathVariable("id") int id) {
        return ResponseEntity.ok(rentService.deleteRent(id));
    }
}
