package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.ExchangeEntity;
import com.boardgame.webstorage.entity.WantBuyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantBuyRepo extends JpaRepository<WantBuyEntity, Integer> {

    List<WantBuyEntity> findByUserid(int id);

    WantBuyEntity findByUseridAndGameid(int userid, int gameid);
}
