package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.SellResponseDTO;
import com.boardgame.webstorage.entity.SellEntity;
import com.boardgame.webstorage.repositories.SellRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SellService {

    private final SellRepo sellRepo;

    @Autowired
    public SellService(SellRepo sellRepo) {
        this.sellRepo = sellRepo;
    }


    public List<SellResponseDTO>  getSellByUserId(int id) {
        log.debug("getSellByUserId: " + id);
        return sellRepo.findByUserid(id).stream().map(SellResponseDTO::new).collect(Collectors.toList());
    }

    public int createSell(int userid, int gameid, String price) {
        SellEntity sellEntity = new SellEntity(userid,gameid,price);
        log.debug("Sell creation: " + sellEntity);
        return sellRepo.save(sellEntity).getId();
    }

    public SellResponseDTO deleteSell(int id) {
        SellEntity sellEntity = sellRepo.findById(id).get();
        sellRepo.deleteById(id);
        log.debug("Sell with id " + id + " was deleted");
        return new SellResponseDTO(sellEntity);
    }
}
