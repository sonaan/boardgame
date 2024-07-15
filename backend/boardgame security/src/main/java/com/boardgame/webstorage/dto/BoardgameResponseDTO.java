package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.BoardgameEntity;
import com.boardgame.webstorage.util.ImageUtility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardgameResponseDTO {
    private int id;
    private String nameEnglish;
    private String nameRussian;
    private String author;
    private String designer;
    private String publishingHouse;
    private String issueYear;
    private String genre;
    private String numberPlayers;
    private String recommendedNumberPlayers;
    private String age;
    private String partyTime;
    private String bggRating;
    private String description;
    private Integer photoid;
    private String photoName;
    private String photoValue;
    private String photoLink;

    private byte[] photoImage;

    public BoardgameResponseDTO(BoardgameEntity boardgameEntity) {
        id = boardgameEntity.getId();
        nameEnglish = boardgameEntity.getNameEnglish();
        nameRussian = boardgameEntity.getNameRussian();
        author = boardgameEntity.getAuthor();
        designer = boardgameEntity.getDesigner();
        publishingHouse = boardgameEntity.getPublishingHouse();
        issueYear = boardgameEntity.getIssueYear();
        genre = boardgameEntity.getGenre();
        numberPlayers = boardgameEntity.getNumberPlayers();
        recommendedNumberPlayers = boardgameEntity.getRecommendedNumberPlayers();
        age = boardgameEntity.getAge();
        partyTime = boardgameEntity.getPartyTime();
        bggRating = boardgameEntity.getBggRating();
        description = boardgameEntity.getDescription();
        photoid = boardgameEntity.getPhotoid();
        photoName = boardgameEntity.getPhoto().getName();
        photoValue = boardgameEntity.getPhoto().getValue();
        photoLink = boardgameEntity.getPhoto().getLink();
        if (boardgameEntity.getPhoto().getImage() != null) {
            photoImage = ImageUtility.decompressImage(boardgameEntity.getPhoto().getImage());
        } else {
            photoImage = null;
        }


    }

}
