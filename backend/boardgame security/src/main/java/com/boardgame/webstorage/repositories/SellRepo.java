package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.SellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellRepo extends JpaRepository<SellEntity, Integer> {

    List<SellEntity> findByUserid(int id);
}
