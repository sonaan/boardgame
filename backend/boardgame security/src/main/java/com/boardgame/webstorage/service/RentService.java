package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.RentResponseDTO;
import com.boardgame.webstorage.entity.RentEntity;
import com.boardgame.webstorage.repositories.RentRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class RentService {

    private final RentRepo rentRepo;

    @Autowired
    public RentService(RentRepo rentRepo) {
        this.rentRepo = rentRepo;
    }


    public List<RentResponseDTO>  getRentByUserId(int id) {
        log.debug("getRentByUserId: " + id);
        return rentRepo.findByUserid(id).stream().map(RentResponseDTO::new).collect(Collectors.toList());
    }

    public int createRent(int userid, int gameid, String price, String rentalPeriod) {
        RentEntity rentEntity = new RentEntity(userid,gameid,price,rentalPeriod);
        log.debug("Rent creation: " + rentEntity);
        return rentRepo.save(rentEntity).getId();
    }

    public RentResponseDTO deleteRent(int id) {
        RentEntity rentEntity = rentRepo.findById(id).get();
        rentRepo.deleteById(id);
        log.debug("Rent with id " + id + " was deleted");
        return new RentResponseDTO(rentEntity);
    }
}
