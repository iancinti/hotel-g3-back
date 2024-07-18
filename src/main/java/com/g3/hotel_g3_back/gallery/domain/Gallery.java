package com.g3.hotel_g3_back.gallery.domain;

import java.util.List;

public class Gallery {
    private final Integer id;
    private String name;
    private List<String> imageUrl;

    public Gallery(Integer id, String name, List<String> imageUrl){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
