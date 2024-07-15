package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "boardgames", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class BoardgameEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name_english")
    private String nameEnglish;
    @Basic
    @Column(name = "name_russian")
    private String nameRussian;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "designer")
    private String designer;
    @Basic
    @Column(name = "publishing_house")
    private String publishingHouse;
    @Basic
    @Column(name = "issue_year")
    private String issueYear;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "number_players")
    private String numberPlayers;
    @Basic
    @Column(name = "recommended_number_players")
    private String recommendedNumberPlayers;
    @Basic
    @Column(name = "age")
    private String age;
    @Basic
    @Column(name = "party_time")
    private String partyTime;
    @Basic
    @Column(name = "bgg_rating")
    private String bggRating;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "photoid")
    private Integer photoid;

    public BoardgameEntity(String nameEnglish, String nameRussian, String author, String designer, String publishingHouse, String issueYear, String genre, String numberPlayers, String recommendedNumberPlayers, String age, String partyTime, String bggRating, String description, Integer photoid) {
        this.nameEnglish = nameEnglish;
        this.nameRussian = nameRussian;
        this.author = author;
        this.designer = designer;
        this.publishingHouse = publishingHouse;
        this.issueYear = issueYear;
        this.genre = genre;
        this.numberPlayers = numberPlayers;
        this.recommendedNumberPlayers = recommendedNumberPlayers;
        this.age = age;
        this.partyTime = partyTime;
        this.bggRating = bggRating;
        this.description = description;
        this.photoid = photoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardgameEntity that = (BoardgameEntity) o;
        return id == that.id && Objects.equals(nameEnglish, that.nameEnglish) && Objects.equals(nameRussian, that.nameRussian) && Objects.equals(author, that.author) && Objects.equals(designer, that.designer) && Objects.equals(publishingHouse, that.publishingHouse) && Objects.equals(issueYear, that.issueYear) && Objects.equals(genre, that.genre) && Objects.equals(numberPlayers, that.numberPlayers) && Objects.equals(recommendedNumberPlayers, that.recommendedNumberPlayers) && Objects.equals(age, that.age) && Objects.equals(partyTime, that.partyTime) && Objects.equals(bggRating, that.bggRating) && Objects.equals(description, that.description) && Objects.equals(photoid, that.photoid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameEnglish, nameRussian, author, designer, publishingHouse, issueYear, genre, numberPlayers, recommendedNumberPlayers, age, partyTime, bggRating, description, photoid);
    }

    @ManyToOne
    @JoinColumn(name = "photoid", insertable = false, updatable = false)
    private PhotosEntity photo;
}
