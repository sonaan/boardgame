package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.WantBuyResponseDTO;
import com.boardgame.webstorage.dto.WantPlayResponseDTO;
import com.boardgame.webstorage.entity.WantPlayEntity;
import com.boardgame.webstorage.repositories.WantPlayRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class WantPlayService {

    private final WantPlayRepo wantPlayRepo;

    @Autowired
    public WantPlayService(WantPlayRepo wantPlayRepo) {
        this.wantPlayRepo = wantPlayRepo;
    }

    public List<WantPlayResponseDTO> getWantPlayByUserId(int id) {
        log.debug("getWantPlayByUserId: " + id);
        return wantPlayRepo.findByUserid(id).stream().map(WantPlayResponseDTO::new).collect(Collectors.toList());
    }

    public int createWantPlay(int userid, int gameid, int photoid) {
        WantPlayEntity wantPlayEntity = new WantPlayEntity(userid,gameid,photoid);
        log.debug("WantPlay creation: " + wantPlayEntity);
        return wantPlayRepo.save(wantPlayEntity).getId();
    }

    public WantPlayResponseDTO deleteWantPlay(int id) {
        WantPlayEntity wantPlayEntity = wantPlayRepo.findById(id).get();
        wantPlayRepo.deleteById(id);
        log.debug("WantPlay with id " + id + " was deleted");
        return new WantPlayResponseDTO(wantPlayEntity);
    }

    public WantPlayResponseDTO existGameByUserId(int userid, int gameid) {
        log.debug("existGameByUserId userid {} gameid {} ", userid, gameid);
        try {
            return new WantPlayResponseDTO(wantPlayRepo.findByUseridAndGameid(userid,gameid));
        } catch (Exception e) {
            return null;
        }
    }
}
