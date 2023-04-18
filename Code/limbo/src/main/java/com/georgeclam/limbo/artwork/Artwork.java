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

/****************************************************************************
 * <b>Title</b>: Artwork.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> Artwork Model, which sets the parameters for the Artwork table in the database.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

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


    /**
     * Constructor for the Artwork Model where artworkId is a unique identifier that is set automatically.
     *
     * @param title
     * @param medium
     * @param yearCreated
     * @param artistId
     */
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
