package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.WantBuyEntity;
import com.boardgame.webstorage.entity.WantPlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantPlayRepo extends JpaRepository<WantPlayEntity, Integer> {

    List<WantPlayEntity> findByUserid(int id);

    WantPlayEntity findByUseridAndGameid(int userid, int gameid);

}
