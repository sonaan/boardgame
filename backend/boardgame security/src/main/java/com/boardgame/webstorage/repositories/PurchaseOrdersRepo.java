package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.PurchaseOrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrdersRepo extends JpaRepository<PurchaseOrdersEntity, Integer> {

    List<PurchaseOrdersEntity> findBySellerid(int id);

    List<PurchaseOrdersEntity> findByBuyerid(int id);
}
