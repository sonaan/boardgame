package com.boardgame.webstorage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "photos", schema = "public", catalog = "education")
@Data
@NoArgsConstructor
public class PhotosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "value")
    private String value;
    @Basic
    @Column(name = "link")
    private String link;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "image")
    private byte[] image;

    public PhotosEntity(String name, String value, String link, String type, byte[] image) {
        this.name = name;
        this.value = value;
        this.link = link;
        this.type = type;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotosEntity)) return false;

        PhotosEntity that = (PhotosEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
