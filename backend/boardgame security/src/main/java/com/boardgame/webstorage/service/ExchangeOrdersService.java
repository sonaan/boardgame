package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.ExchangeOrdersResponseDTO;
import com.boardgame.webstorage.dto.PurchaseOrdersResponseDTO;
import com.boardgame.webstorage.entity.ExchangeOrdersEntity;
import com.boardgame.webstorage.entity.PurchaseOrdersEntity;
import com.boardgame.webstorage.repositories.ExchangeOrdersRepo;
import com.boardgame.webstorage.repositories.PurchaseOrdersRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ExchangeOrdersService {

    private final ExchangeOrdersRepo exchangeOrdersRepo;

    @Autowired
    public ExchangeOrdersService(ExchangeOrdersRepo exchangeOrdersRepo) {
        this.exchangeOrdersRepo = exchangeOrdersRepo;
    }

    public List<ExchangeOrdersResponseDTO> getAllExchangeOrders() {
        log.debug("getAllExchangeOrders");
        return exchangeOrdersRepo.findAll().stream().map(ExchangeOrdersResponseDTO::new).collect(Collectors.toList());
    }

    public List<ExchangeOrdersResponseDTO> getExchangeOrdersByUserid1(int id) {
        log.debug("getExchangeOrdersByUserid1: " + id);
        return exchangeOrdersRepo.findByUserid1(id).stream().map(ExchangeOrdersResponseDTO::new).collect(Collectors.toList());
    }

    public List<ExchangeOrdersResponseDTO> getExchangeOrdersByUserid2(int id) {
        log.debug("getRentOrdersByBuyerid: " + id);
        return exchangeOrdersRepo.findByUserid2(id).stream().map(ExchangeOrdersResponseDTO::new).collect(Collectors.toList());
    }

    public int createExchangeOrders(Integer userid1, Integer gameid1, String exchangerCity, String address, String description1, String photoLink1) {
        ExchangeOrdersEntity exchangeOrdersEntity = new ExchangeOrdersEntity(userid1,gameid1,exchangerCity,address,description1,photoLink1);
        log.debug("ExchangeOrders creation: " + exchangeOrdersEntity);
        return exchangeOrdersRepo.save(exchangeOrdersEntity).getId();
    }

    public int updateExchangeOrders(int id, Integer userid2, Integer gameid2, Integer orderStateId, String description2, String photoLink2) {
        var exchangeOrdersEntity = exchangeOrdersRepo.findById(id).orElseThrow(() -> new RuntimeException
                ("ExchangeOrders with id: " + id + "not found"));
        exchangeOrdersEntity.setUserid2(userid2);
        exchangeOrdersEntity.setGameid2(gameid2);
        exchangeOrdersEntity.setOrderStateId(orderStateId);
        exchangeOrdersEntity.setDescription2(description2);
        exchangeOrdersEntity.setPhotoLink2(photoLink2);
        exchangeOrdersRepo.saveAndFlush(exchangeOrdersEntity);
        log.debug("ExchangeOrders was updated : " + exchangeOrdersEntity);
        return exchangeOrdersEntity.getId();
    }


    public ExchangeOrdersResponseDTO deleteExchangeOrders(int id) {
        ExchangeOrdersEntity exchangeOrdersEntity = exchangeOrdersRepo.findById(id).get();
        exchangeOrdersRepo.deleteById(id);
        log.debug("ExchangeOrders with id " + id + " was deleted");
        return new ExchangeOrdersResponseDTO(exchangeOrdersEntity);
    }
}
