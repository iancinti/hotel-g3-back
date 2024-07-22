package com.g3.hotel_g3_back.gallery.domain;

import java.util.List;

public class Gallery {
    private Integer idImage;
    private Integer idRoom;
    private Integer idAttraction;
    private List<String> imageUrl;

    public Gallery(Integer idImage, Integer idRoom, Integer idAttraction, List<String> imageUrl) {
        this.idImage = idImage;
        this.idRoom = idRoom;
        this.idAttraction = idAttraction;
        this.imageUrl = imageUrl;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getIdAttraction() {
        return idAttraction;
    }

    public void setIdAttraction(Integer idAttraction) {
        this.idAttraction = idAttraction;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
