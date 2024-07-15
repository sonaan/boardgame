package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.PlayedGameResponseDTO;
import com.boardgame.webstorage.dto.WantPlayResponseDTO;
import com.boardgame.webstorage.entity.PlayedGameEntity;
import com.boardgame.webstorage.repositories.PlayedGameRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PlayedGameService {

    private final PlayedGameRepo playedGameRepo;

    @Autowired
    public PlayedGameService(PlayedGameRepo playedGameRepo) {
        this.playedGameRepo = playedGameRepo;
    }


    public List<PlayedGameResponseDTO>  getPlayedGameByUserId(int id) {
        log.debug("getPlayedGameByUserId: " + id);
        return playedGameRepo.findByUserid(id).stream().map(PlayedGameResponseDTO::new).collect(Collectors.toList());
    }

    public int createPlayedGame(int userid, int gameid, int photoid) {
        PlayedGameEntity playedGameEntity = new PlayedGameEntity(userid,gameid,photoid);
        log.debug("PlayedGame creation: " + playedGameEntity);
        return playedGameRepo.save(playedGameEntity).getId();
    }

    public PlayedGameResponseDTO deletePlayedGame(int id) {
        PlayedGameEntity playedGameEntity = playedGameRepo.findById(id).get();
        playedGameRepo.deleteById(id);
        log.debug("PlayedGame with id " + id + " was deleted");
        return new PlayedGameResponseDTO(playedGameEntity);
    }

    public PlayedGameResponseDTO existGameByUserId(int userid, int gameid) {
        log.debug("existGameByUserId userid {} gameid {} ", userid, gameid);
        try {
            return new PlayedGameResponseDTO(playedGameRepo.findByUseridAndGameid(userid,gameid));
        } catch (Exception e) {
            return null;
        }
    }
}
