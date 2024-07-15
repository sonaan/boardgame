package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepo extends JpaRepository<PaymentMethodEntity, Integer> {
}
