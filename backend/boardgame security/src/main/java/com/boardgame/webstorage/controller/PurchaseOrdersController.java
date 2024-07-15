package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.*;
import com.boardgame.webstorage.service.PurchaseOrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/purchaseorder/")
public class PurchaseOrdersController {

    private final PurchaseOrdersService purchaseOrdersService;

    public PurchaseOrdersController(PurchaseOrdersService purchaseOrdersService) {
        this.purchaseOrdersService = purchaseOrdersService;
    }

    @GetMapping(value = "/allrows")
    public ResponseEntity<List<PurchaseOrdersResponseDTO>> getAllRows() {
        return ResponseEntity.ok(purchaseOrdersService.getAllPurchaseOrders());
    }

    @GetMapping(value = "/seller/{id}")
    public ResponseEntity<List<PurchaseOrdersResponseDTO>> getPurchaseOrdersBySellerid(@PathVariable("id") int id) {
        return ResponseEntity.ok(purchaseOrdersService.getPurchaseOrdersBySellerid(id));
    }

    @GetMapping(value = "/buyer/{id}")
    public ResponseEntity<List<PurchaseOrdersResponseDTO>> getPurchaseOrdersByBuyerid(@PathVariable("id") int id) {
        return ResponseEntity.ok(purchaseOrdersService.getPurchaseOrdersByBuyerid(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Integer> createSell(@RequestBody PurchaseOrdersRequestDTO body) {
        return ResponseEntity.ok(purchaseOrdersService.createPurchaseOrders(body.getSellerid(), body.getGameid(), body.getSellerCity(), body.getAddress(),body.getPrice(), body.getShippingMethod(), body.getDescription(), body.getPhotoLink()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PurchaseOrdersResponseDTO> deleteSell(@PathVariable("id") int id) {
        return ResponseEntity.ok(purchaseOrdersService.deletePurchaseOrders(id));
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<Integer> updateSell(@RequestBody PurchaseOrdersRequestDTO body) {
        return ResponseEntity.ok(purchaseOrdersService.updatePurchaseOrders(body.getId(), body.getBuyerid(), body.getOrderStateId(), body.getPaymentMethodId(), body.getPaymentStateId()));
    }
}
