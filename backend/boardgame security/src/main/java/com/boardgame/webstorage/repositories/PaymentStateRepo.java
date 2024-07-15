package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.PaymentStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStateRepo extends JpaRepository<PaymentStateEntity, Integer> {
}
