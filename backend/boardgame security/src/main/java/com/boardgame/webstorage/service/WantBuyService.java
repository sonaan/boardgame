package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.ExchangeResponseDTO;
import com.boardgame.webstorage.dto.WantBuyResponseDTO;
import com.boardgame.webstorage.entity.WantBuyEntity;
import com.boardgame.webstorage.repositories.WantBuyRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class WantBuyService {

    private final WantBuyRepo wantBuyRepo;

    @Autowired
    public WantBuyService(WantBuyRepo wantBuyRepo) {
        this.wantBuyRepo = wantBuyRepo;
    }


    public List<WantBuyResponseDTO>  getWantBuyByUserId(int id) {
        log.debug("getWantBuyByUserId: " + id);
        return wantBuyRepo.findByUserid(id).stream().map(WantBuyResponseDTO::new).collect(Collectors.toList());
    }

    public int createWantBuy(int userid, int gameid, int photoid) {
        WantBuyEntity wantBuyEntity = new WantBuyEntity(userid,gameid,photoid);
        log.debug("WantBuy creation: " + wantBuyEntity);
        return wantBuyRepo.save(wantBuyEntity).getId();
    }

    public WantBuyResponseDTO deleteWantBuy(int id) {
        WantBuyEntity wantBuyEntity = wantBuyRepo.findById(id).get();
        wantBuyRepo.deleteById(id);
        log.debug("WantBuy with id " + id + " was deleted");
        return new WantBuyResponseDTO(wantBuyEntity);
    }

    public WantBuyResponseDTO existGameByUserId(int userid, int gameid) {
        log.debug("existGameByUserId userid {} gameid {} ", userid, gameid);
        try {
            return new WantBuyResponseDTO(wantBuyRepo.findByUseridAndGameid(userid,gameid));
        } catch (Exception e) {
            return null;
        }
    }
}
