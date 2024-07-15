package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.RentOrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentOrdersRepo extends JpaRepository<RentOrdersEntity, Integer> {

    List<RentOrdersEntity> findByGameOwnerid(int id);

    List<RentOrdersEntity> findByTenantid(int id);
}
