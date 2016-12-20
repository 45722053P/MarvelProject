package com.example.a45722053p.marvelproject;

import java.io.Serializable;

/**
 * Created by 45722053p on 20/12/16.
 */

public class Character implements Serializable {

    int id;
    String name;
    String description;
    String comics;
    String stories;
    String series;
    String ImageUrl;


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

    public String getComics() {
        return comics;
    }

    public void setComics(String comics) {
        this.comics = comics;
    }

    public String getStories() {
        return stories;
    }

    public void setStories(String stories) {
        this.stories = stories;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", comics='" + comics + '\'' +
                ", stories='" + stories + '\'' +
                ", series='" + series + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                '}';
    }
}
