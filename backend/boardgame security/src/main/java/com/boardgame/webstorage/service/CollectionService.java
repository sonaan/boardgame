package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.CollectionResponseDTO;
import com.boardgame.webstorage.dto.UserResponseDTO;
import com.boardgame.webstorage.entity.CollectionEntity;
import com.boardgame.webstorage.repositories.CollectionRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CollectionService {

    private final CollectionRepo collectionRepo;

    @Autowired
    public CollectionService(CollectionRepo collectionRepo) {
        this.collectionRepo = collectionRepo;
    }


    public List<CollectionResponseDTO>  getCollectionByUserId(int id) {
        log.debug("getCollectionByUserId: " + id);
        return collectionRepo.findByUserid(id).stream().map(CollectionResponseDTO::new).collect(Collectors.toList());
    }

    public int createCollection(int userid, int gameid, int photoid) {
        CollectionEntity collectionEntity = new CollectionEntity(userid,gameid,photoid);
        log.debug("Collection creation: " + collectionEntity);
        return collectionRepo.save(collectionEntity).getId();
    }

    public CollectionResponseDTO deleteCollection(int id) {
        CollectionEntity collectionEntity = collectionRepo.findById(id).get();
        collectionRepo.deleteById(id);
        log.debug("Collection with id " + id + " was deleted");
        return new CollectionResponseDTO(collectionEntity);
    }

    public CollectionResponseDTO existGameByUserId(int userid, int gameid) {
        log.debug("existGameByUserId userid {} gameid {} ", userid, gameid);
        try {
            return new CollectionResponseDTO(collectionRepo.findByUseridAndGameid(userid,gameid));
        } catch (Exception e) {
            return null;
        }
    }
}
