package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepo extends JpaRepository<CollectionEntity, Integer> {

    List<CollectionEntity> findByUserid(int id);
    CollectionEntity findByUseridAndGameid(int userid, int gameid);

}
