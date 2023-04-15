package com.georgeclam.limbo.artwork;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

@Entity
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artworkId;

    @NotBlank
    private String title;

    @NotNull
    private Long artistId;

    @NotBlank
    private String medium;

    @NotNull
    private Integer yearCreated;

    public Artwork(Optional<String> title, Optional<String> medium, Optional<Integer> yearCreated, Optional<Long> artistId) {
        if (title.isPresent()) this.title = title.get();
        if (medium.isPresent()) this.medium = medium.get();
        if (yearCreated.isPresent()) this.yearCreated = yearCreated.get();
        if (artistId.isPresent()) this.artistId = artistId.get();
    }

    public Artwork(String title, String medium, Integer yearCreated, Long artistId) {
        this.title = title;
        this.artistId = artistId;
        this.medium = medium;
        this.yearCreated = yearCreated;
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

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
}
