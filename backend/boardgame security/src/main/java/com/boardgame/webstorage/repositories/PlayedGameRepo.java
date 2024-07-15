package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.ExchangeEntity;
import com.boardgame.webstorage.entity.PlayedGameEntity;
import com.boardgame.webstorage.entity.WantPlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayedGameRepo extends JpaRepository<PlayedGameEntity, Integer> {

    List<PlayedGameEntity> findByUserid(int id);

    PlayedGameEntity findByUseridAndGameid(int userid, int gameid);
}
