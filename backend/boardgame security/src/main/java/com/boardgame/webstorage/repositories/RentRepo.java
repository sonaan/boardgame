package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepo extends JpaRepository<RentEntity, Integer> {

    List<RentEntity> findByUserid(int id);
}
