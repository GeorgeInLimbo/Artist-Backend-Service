package com.georgeclam.limbo.artwork;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
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



    public Artwork(String title,
                   String medium,
                   Integer yearCreated,
                   Long artistId) {
        this.title = title;
        this.artistId = artistId;
        this.medium = medium;
        this.yearCreated = yearCreated;
    }
}
