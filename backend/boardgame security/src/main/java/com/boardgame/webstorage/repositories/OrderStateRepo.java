package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.OrderStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStateRepo extends JpaRepository<OrderStateEntity, Integer> {
}
