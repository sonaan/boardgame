package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.BoardgameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardgameRepo extends JpaRepository<BoardgameEntity, Integer> {

    List<BoardgameEntity> findByNameEnglishLikeOrNameRussianLike(String nameEnglish, String nameRussian);

}
