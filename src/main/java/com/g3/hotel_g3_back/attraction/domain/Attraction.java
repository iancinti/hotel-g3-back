package com.g3.hotel_g3_back.attraction.domain;

public class Attraction {

    private int id;
    private String name;
    private String description;
    private String urlImage;

    public Attraction(int id, String name, String description, String urlImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
