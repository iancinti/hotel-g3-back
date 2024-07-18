package com.g3.hotel_g3_back.attraction.domain;

public class Attraction {

    private Integer id;
    private String title;
    private String description;

    public Attraction(Integer id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}