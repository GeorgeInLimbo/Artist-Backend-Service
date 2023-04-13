package com.georgeclam.limbo.artwork;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artworkId;

    @NotBlank
    private String title;

//    @NotBlank
//    private Long artistId;

    @NotBlank
    private String medium;

    private Integer yearCreated;

    private String path;

    public Artwork(String title, String medium, Integer yearCreated, String path) {
        this.title = title;
//        this.artistId = artistId;
        this.medium = medium;
        this.yearCreated = yearCreated;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Artwork() {
    }

    public Long getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Long artworkId) {
        this.artworkId = artworkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Long getArtistId() {
//        return artistId;
//    }
//
//    public void setArtistId(Long artistId) {
//        this.artistId = artistId;
//    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Integer getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(Integer yearCreated) {
        this.yearCreated = yearCreated;
    }
}
