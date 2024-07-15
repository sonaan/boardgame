package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.CollectionEntity;
import com.boardgame.webstorage.entity.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepo extends JpaRepository<ExchangeEntity, Integer> {

    List<ExchangeEntity> findByUserid(int id);

    ExchangeEntity findByUseridAndGameid(int userid, int gameid);
}
