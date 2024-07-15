package com.boardgame.webstorage.dto;

import com.boardgame.webstorage.entity.PhotosEntity;
import com.boardgame.webstorage.entity.RentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoRequestDTO {
    private int id;
    private String name;
    private String value;
    private String link;

    public PhotoRequestDTO(PhotosEntity photosEntity) {
        id = photosEntity.getId();
        name = photosEntity.getName();
        value = photosEntity.getValue();
        link = photosEntity.getLink();
    }

}
