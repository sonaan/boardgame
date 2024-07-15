package com.boardgame.webstorage.repositories;

import com.boardgame.webstorage.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findByLoginLike(String login);
    UserEntity findByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);
}
