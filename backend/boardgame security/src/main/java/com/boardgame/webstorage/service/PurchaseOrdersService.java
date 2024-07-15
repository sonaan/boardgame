package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.BoardgameResponseDTO;
import com.boardgame.webstorage.dto.PurchaseOrdersResponseDTO;
import com.boardgame.webstorage.entity.PurchaseOrdersEntity;
import com.boardgame.webstorage.repositories.PurchaseOrdersRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PurchaseOrdersService {

    private final PurchaseOrdersRepo purchaseOrdersRepo;

    @Autowired
    public PurchaseOrdersService(PurchaseOrdersRepo purchaseOrdersRepo) {
        this.purchaseOrdersRepo = purchaseOrdersRepo;
    }

    public List<PurchaseOrdersResponseDTO> getAllPurchaseOrders() {
        log.debug("getAllPurchaseOrders");
        return purchaseOrdersRepo.findAll().stream().map(PurchaseOrdersResponseDTO::new).collect(Collectors.toList());
    }

    public List<PurchaseOrdersResponseDTO> getPurchaseOrdersBySellerid(int id) {
        log.debug("getPurchaseOrdersBySellerid: " + id);
        return purchaseOrdersRepo.findBySellerid(id).stream().map(PurchaseOrdersResponseDTO::new).collect(Collectors.toList());
    }

    public List<PurchaseOrdersResponseDTO> getPurchaseOrdersByBuyerid(int id) {
        log.debug("getPurchaseOrdersByBuyerid: " + id);
        return purchaseOrdersRepo.findByBuyerid(id).stream().map(PurchaseOrdersResponseDTO::new).collect(Collectors.toList());
    }

    public int createPurchaseOrders(int sellerid, int gameid, String sellerCity, String address, String price, String shippingMethod, String description, String photoLink) {
        PurchaseOrdersEntity purchaseOrdersEntity = new PurchaseOrdersEntity(sellerid,gameid,sellerCity,address,price,shippingMethod,description,photoLink);
        log.debug("PurchaseOrders creation: " + purchaseOrdersEntity);
        return purchaseOrdersRepo.save(purchaseOrdersEntity).getId();
    }

    public int updatePurchaseOrders(int id, int buyerid, Integer orderStateId, Integer paymentMethodId, Integer paymentStateId) {
        var purchaseOrdersEntity = purchaseOrdersRepo.findById(id).orElseThrow(() -> new RuntimeException
                ("PurchaseOrder with id: " + id + "not found"));
        purchaseOrdersEntity.setBuyerid(buyerid);
        purchaseOrdersEntity.setOrderStateId(orderStateId);
        purchaseOrdersEntity.setPaymentMethodId(paymentMethodId);
        purchaseOrdersEntity.setPaymentStateId(paymentStateId);
        purchaseOrdersRepo.saveAndFlush(purchaseOrdersEntity);
        log.debug("PurchaseOrders was updated : " + purchaseOrdersEntity);
        return purchaseOrdersEntity.getId();
    }


    public PurchaseOrdersResponseDTO deletePurchaseOrders(int id) {
        PurchaseOrdersEntity purchaseOrdersEntity = purchaseOrdersRepo.findById(id).get();
        purchaseOrdersRepo.deleteById(id);
        log.debug("PurchaseOrders with id " + id + " was deleted");
        return new PurchaseOrdersResponseDTO(purchaseOrdersEntity);
    }
}
