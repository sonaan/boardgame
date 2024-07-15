package com.boardgame.webstorage.repositories;


import com.boardgame.webstorage.entity.ExchangeOrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeOrdersRepo extends JpaRepository<ExchangeOrdersEntity, Integer> {

    List<ExchangeOrdersEntity> findByUserid1(int id);

    List<ExchangeOrdersEntity> findByUserid2(int id);
}
