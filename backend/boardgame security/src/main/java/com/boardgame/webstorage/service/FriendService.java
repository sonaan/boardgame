package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.FriendResponseDTO;
import com.boardgame.webstorage.entity.FriendEntity;
import com.boardgame.webstorage.repositories.FriendRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class FriendService {

    private final FriendRepo friendRepo;

    @Autowired
    public FriendService(FriendRepo friendRepo) {
        this.friendRepo = friendRepo;
    }


    public List<FriendResponseDTO>  getFriendByUserId(int id) {
        log.debug("getFriendByUserId: " + id);
        return friendRepo.findByUserid1OrUserid2(id,id).stream().map(FriendResponseDTO::new).collect(Collectors.toList());
    }

    public int createFriend(int userid1, int userid2) {
        FriendEntity friendEntity = new FriendEntity(userid1,userid2);
        log.debug("Friend creation: " + friendEntity);
        return friendRepo.save(friendEntity).getId();
    }

    public FriendResponseDTO deleteFriend(int id) {
        FriendEntity friendEntity = friendRepo.findById(id).get();
        friendRepo.deleteById(id);
        log.debug("Friend with id " + id + " was deleted");
        return new FriendResponseDTO(friendEntity);
    }
}
