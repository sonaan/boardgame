package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.RentOrdersResponseDTO;
import com.boardgame.webstorage.entity.RentOrdersEntity;
import com.boardgame.webstorage.repositories.RentOrdersRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class RentOrdersService {

    private final RentOrdersRepo rentOrdersRepo;

    @Autowired
    public RentOrdersService(RentOrdersRepo rentOrdersRepo) {
        this.rentOrdersRepo = rentOrdersRepo;
    }


    public List<RentOrdersResponseDTO> getRentOrdersByGameOwnerid(int id) {
        log.debug("getRentOrdersByGameOwnerid: " + id);
        return rentOrdersRepo.findByGameOwnerid(id).stream().map(RentOrdersResponseDTO::new).collect(Collectors.toList());
    }

    public List<RentOrdersResponseDTO> getRentOrdersByTenantid(int id) {
        log.debug("getRentOrdersByTenantid: " + id);
        return rentOrdersRepo.findByTenantid(id).stream().map(RentOrdersResponseDTO::new).collect(Collectors.toList());
    }

    public int createRentOrders(int gameOwnerid, int tenantid, int gameid, Date dateBegin, Date dateEnd, String price, int paymentMethodId, int paymentStateId, int orderStateId) {
        RentOrdersEntity rentOrdersEntity = new RentOrdersEntity(gameOwnerid,tenantid,gameid,dateBegin,dateEnd,price,paymentMethodId,paymentStateId,orderStateId);
        log.debug("RentOrders creation: " + rentOrdersEntity);
        return rentOrdersRepo.save(rentOrdersEntity).getId();
    }

    public RentOrdersResponseDTO deleteRentOrders(int id) {
        RentOrdersEntity rentOrdersEntity = rentOrdersRepo.findById(id).get();
        rentOrdersRepo.deleteById(id);
        log.debug("RentOrders with id " + id + " was deleted");
        return new RentOrdersResponseDTO(rentOrdersEntity);
    }
}
