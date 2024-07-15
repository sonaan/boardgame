package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.*;
import com.boardgame.webstorage.service.ExchangeOrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/exchangeorder/")
public class ExchangeOrdersController {

    private final ExchangeOrdersService exchangeOrdersService;

    public ExchangeOrdersController(ExchangeOrdersService exchangeOrdersService) {
        this.exchangeOrdersService = exchangeOrdersService;
    }

    @GetMapping(value = "/allrows")
    public ResponseEntity<List<ExchangeOrdersResponseDTO>> getAllRows() {
        return ResponseEntity.ok(exchangeOrdersService.getAllExchangeOrders());
    }

    @GetMapping(value = "/user1/{id}")
    public ResponseEntity<List<ExchangeOrdersResponseDTO>> getExchangeOrdersByUsereid1(@PathVariable("id") int id) {
        return ResponseEntity.ok(exchangeOrdersService.getExchangeOrdersByUserid1(id));
    }

    @GetMapping(value = "/user2/{id}")
    public ResponseEntity<List<ExchangeOrdersResponseDTO>> getExchangeOrdersByUsereid2(@PathVariable("id") int id) {
        return ResponseEntity.ok(exchangeOrdersService.getExchangeOrdersByUserid2(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createExchangeOrders(@RequestBody ExchangeOrdersRequestDTO body) {
        return ResponseEntity.ok(exchangeOrdersService.createExchangeOrders(body.getUserid1(), body.getGameid1(), body.getExchangerCity(), body.getAddress(),body.getDescription1(), body.getPhotoLink1()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ExchangeOrdersResponseDTO> deleteExchangeOrders(@PathVariable("id") int id) {
        return ResponseEntity.ok(exchangeOrdersService.deleteExchangeOrders(id));
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<Integer> updateExchangeOrders(@RequestBody ExchangeOrdersRequestDTO body) {
        return ResponseEntity.ok(exchangeOrdersService.updateExchangeOrders(body.getId(), body.getUserid2(), body.getGameid2(), body.getOrderStateId(), body.getDescription2(), body.getPhotoLink2()));
    }
}
