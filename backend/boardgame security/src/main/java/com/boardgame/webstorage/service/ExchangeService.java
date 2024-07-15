package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.CollectionResponseDTO;
import com.boardgame.webstorage.dto.ExchangeResponseDTO;
import com.boardgame.webstorage.entity.ExchangeEntity;
import com.boardgame.webstorage.repositories.ExchangeRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ExchangeService {

    private final ExchangeRepo exchangeRepo;

    @Autowired
    public ExchangeService(ExchangeRepo exchangeRepo) {
        this.exchangeRepo = exchangeRepo;
    }


    public List<ExchangeResponseDTO>  getExchangeByUserId(int id) {
        log.debug("getExchangeByUserId: " + id);
        return exchangeRepo.findByUserid(id).stream().map(ExchangeResponseDTO::new).collect(Collectors.toList());
    }

    public int createExchange(int userid, int gameid, int photoid) {
        ExchangeEntity exchangeEntity = new ExchangeEntity(userid,gameid,photoid);
        log.debug("ExchangeEntity creation: " + exchangeEntity);
        return exchangeRepo.save(exchangeEntity).getId();
    }

    public ExchangeResponseDTO deleteExchange(int id) {
        ExchangeEntity exchangeEntity = exchangeRepo.findById(id).get();
        exchangeRepo.deleteById(id);
        log.debug("Exchange with id " + id + " was deleted");
        return new ExchangeResponseDTO(exchangeEntity);
    }

    public ExchangeResponseDTO existGameByUserId(int userid, int gameid) {
        log.debug("existGameByUserId userid {} gameid {} ", userid, gameid);
        try {
            return new ExchangeResponseDTO(exchangeRepo.findByUseridAndGameid(userid,gameid));
        } catch (Exception e) {
            return null;
        }
    }
}
