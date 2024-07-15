package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.BoardgameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardgameRequestDTO {

    private int id;
    private String nameEnglish;
    private String nameRussian;
    private String author;
    private String designer;
    private String publishingHouse;
    private String issuiYear;
    private String genre;
    private String numberPlayers;
    private String recommendedNumberPlayers;
    private String age;
    private String partyTime;
    private String bggRating;
    private String description;
    private Integer photoid;

    public BoardgameRequestDTO(BoardgameEntity boardgameEntity) {
        nameEnglish = boardgameEntity.getNameEnglish();
        nameRussian = boardgameEntity.getNameRussian();
        author = boardgameEntity.getAuthor();
        designer = boardgameEntity.getDesigner();
        publishingHouse = boardgameEntity.getPublishingHouse();
        issuiYear = boardgameEntity.getIssueYear();
        genre = boardgameEntity.getGenre();
        numberPlayers = boardgameEntity.getNumberPlayers();
        recommendedNumberPlayers = boardgameEntity.getRecommendedNumberPlayers();
        age = boardgameEntity.getAge();
        partyTime = boardgameEntity.getPartyTime();
        bggRating = boardgameEntity.getBggRating();
        description = boardgameEntity.getDescription();
        photoid = boardgameEntity.getPhotoid();
    }

}
