package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.BoardgameResponseDTO;
import com.boardgame.webstorage.entity.BoardgameEntity;
import com.boardgame.webstorage.repositories.BoardgameRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BoardgameService {

    private final BoardgameRepo boardgameRepo;

    @Autowired
    public BoardgameService(BoardgameRepo boardgameRepo) {
        this.boardgameRepo = boardgameRepo;
    }

    public List<BoardgameResponseDTO> getAllBoardgames() {
        log.debug("getAllBoardgames");
        return boardgameRepo.findAll().stream().map(BoardgameResponseDTO::new).collect(Collectors.toList());
    }

    public BoardgameResponseDTO getBoardgameById(int id) {
        log.debug("getBoardgameById: " + id);
        return new BoardgameResponseDTO(boardgameRepo.findById(id).get());
    }

    public List<BoardgameResponseDTO> getBoardgameByName(String name) {
        log.debug("getBoardgameByName: " + name);
        return boardgameRepo.findByNameEnglishLikeOrNameRussianLike(name,name).stream().map(BoardgameResponseDTO::new).collect(Collectors.toList());
    }

    public int createBoardgame(String nameEnglish, String nameRussian, String author, String designer, String publishingHouse, String issuiYear, String genre, String numberPlayers, String recommendedNumberPlayers, String age, String partyTime, String bggRating, String description, Integer photoid) {
        BoardgameEntity boardgameEntity = new BoardgameEntity(nameEnglish, nameRussian, author, designer, publishingHouse, issuiYear, genre, numberPlayers, recommendedNumberPlayers, age, partyTime, bggRating, description, photoid);
        log.debug("Boardgame creation: " + boardgameEntity);
        return boardgameRepo.save(boardgameEntity).getId();
    }

    public BoardgameResponseDTO updateBoardgame(int id, String nameEnglish, String nameRussian, String author, String designer, String publishingHouse, String issuiYear, String genre, String numberPlayers, String recommendedNumberPlayers, String age,
                                                String partyTime, String bggRating, String description, Integer photoid) {
        BoardgameEntity boardgameEntity = boardgameRepo.findById(id).get();
        boardgameEntity.setNameEnglish(nameEnglish);
        boardgameEntity.setNameRussian(nameRussian);
        boardgameEntity.setAuthor(author);
        boardgameEntity.setDesigner(designer);
        boardgameEntity.setPublishingHouse(publishingHouse);
        boardgameEntity.setIssueYear(issuiYear);
        boardgameEntity.setGenre(genre);
        boardgameEntity.setNumberPlayers(numberPlayers);
        boardgameEntity.setRecommendedNumberPlayers(recommendedNumberPlayers);
        boardgameEntity.setAge(age);
        boardgameEntity.setPartyTime(partyTime);
        boardgameEntity.setBggRating(bggRating);
        boardgameEntity.setDescription(description);
        boardgameEntity.setPhotoid(photoid);
        boardgameRepo.save(boardgameEntity);
        log.debug("Boardgame was updated " + boardgameEntity);
        return new BoardgameResponseDTO(boardgameRepo.findById(id).get());
    }

    public BoardgameResponseDTO deleteBoardgame(int id) {
        BoardgameEntity boardgameEntity = boardgameRepo.findById(id).get();
        boardgameRepo.deleteById(id);
        log.debug("Boardgame with id " + id + " was deleted");
        return new BoardgameResponseDTO(boardgameEntity);
    }
}
