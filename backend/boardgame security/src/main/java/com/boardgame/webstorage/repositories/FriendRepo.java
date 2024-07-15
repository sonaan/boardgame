package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepo extends JpaRepository<FriendEntity, Integer> {

    List<FriendEntity> findByUserid1OrUserid2(Integer userid1, Integer userid2);
}
