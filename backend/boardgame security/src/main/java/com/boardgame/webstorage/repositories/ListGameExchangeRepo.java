package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.ListGameExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListGameExchangeRepo extends JpaRepository<ListGameExchangeEntity, Integer> {

    List<ListGameExchangeEntity> findByExchangeid(int id);
}
