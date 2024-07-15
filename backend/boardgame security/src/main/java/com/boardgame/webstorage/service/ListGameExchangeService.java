package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.ListGameExchangeResponseDTO;
import com.boardgame.webstorage.dto.PurchaseOrdersResponseDTO;
import com.boardgame.webstorage.entity.ListGameExchangeEntity;
import com.boardgame.webstorage.repositories.ListGameExchangeRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ListGameExchangeService {

    private final ListGameExchangeRepo listGameExchangeRepo;

    @Autowired
    public ListGameExchangeService(ListGameExchangeRepo listGameExchangeRepo) {
        this.listGameExchangeRepo = listGameExchangeRepo;
    }

    public List<ListGameExchangeResponseDTO> getAllListGameExchanges() {
        log.debug("getAllListGameExchanges");
        return listGameExchangeRepo.findAll().stream().map(ListGameExchangeResponseDTO::new).collect(Collectors.toList());
    }

    public List<ListGameExchangeResponseDTO> getListGameExchangeByExchangeId(int id) {
        log.debug("getListGameExchangeByExchangeId: " + id);
        return listGameExchangeRepo.findByExchangeid(id).stream().map(ListGameExchangeResponseDTO::new).collect(Collectors.toList());
    }

    public int createListGameExchange(int exchangeid, int gameid) {
        ListGameExchangeEntity listGameExchangeEntity = new ListGameExchangeEntity(exchangeid,gameid);
        log.debug("ListGameExchange creation: " + listGameExchangeEntity);
        return listGameExchangeRepo.save(listGameExchangeEntity).getId();
    }

    public ListGameExchangeResponseDTO deleteListGameExchange(int id) {
        ListGameExchangeEntity listGameExchangeEntity = listGameExchangeRepo.findById(id).get();
        listGameExchangeRepo.deleteById(id);
        log.debug("ListGameExchange with id " + id + " was deleted");
        return new ListGameExchangeResponseDTO(listGameExchangeEntity);
    }
}
