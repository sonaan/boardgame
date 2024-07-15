package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.PhotosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends JpaRepository<PhotosEntity, Integer> {

    PhotosEntity findByName(String name);
}
