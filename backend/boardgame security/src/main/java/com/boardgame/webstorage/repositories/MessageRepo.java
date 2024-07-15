package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<MessageEntity, Integer> {

    List<MessageEntity> findByUseridReceive(int id);

    List<MessageEntity> findByUseridSend(int id);
}
