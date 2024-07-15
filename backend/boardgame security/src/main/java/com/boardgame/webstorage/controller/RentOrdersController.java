package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.RentOrdersRequestDTO;
import com.boardgame.webstorage.dto.RentOrdersResponseDTO;
import com.boardgame.webstorage.service.RentOrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rentorder/")
public class RentOrdersController {

    private final RentOrdersService rentOrderService;

    public RentOrdersController(RentOrdersService rentOrderService) {
        this.rentOrderService = rentOrderService;
    }

    @GetMapping(value = "/gameowner/{id}")
    public ResponseEntity<List<RentOrdersResponseDTO>> getRentOrdersByGameOwnerid(@PathVariable("id") int id) {
        return ResponseEntity.ok(rentOrderService.getRentOrdersByGameOwnerid(id));
    }

    @GetMapping(value = "/tenant/{id}")
    public ResponseEntity<List<RentOrdersResponseDTO>> getRentOrdersByTenantid(@PathVariable("id") int id) {
        return ResponseEntity.ok(rentOrderService.getRentOrdersByTenantid(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createSell(@RequestBody RentOrdersRequestDTO body) {
        return ResponseEntity.ok(rentOrderService.createRentOrders(body.getGameOwnerid(),body.getTenantid(),body.getGameid(),body.getDateBegin(),body.getDateEnd(),body.getPrice(),body.getPaymentMethodId(),body.getPaymentStateId(),body.getOrderStateId()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<RentOrdersResponseDTO> deleteSell(@PathVariable("id") int id) {
        return ResponseEntity.ok(rentOrderService.deleteRentOrders(id));
    }
}
