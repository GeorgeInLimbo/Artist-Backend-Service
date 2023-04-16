package com.georgeclam.limbo.artwork;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Optional;

/**
 * This class represents an Artwork Model for the purpose of searching for artwork
 * with optional params. It represents an Artwork object, but allows for more flexibility
 * based on the functionality required in the controller.
 *
 * Represents a search payload where each field is an optional filter applied to
 * queries on the artwork resource set.
 *
 * ChatGPT: DTOs are often used to carry data from the data access layer
 * (e.g., repositories) to the presentation layer (e.g., controllers) or vice versa.
 *
 * ChatGPT: The Service class focuses on the behavior of the application, while the
 * DTO class focuses on the structure of the data being transferred.
 */
@Getter
@Setter
@ToString
public class ArtworkSearchDTO {
    private Long artworkId;
    private String title;
    private Long artistId;
    private String medium;
    private Integer yearCreated;

    public ArtworkSearchDTO(
                   Optional<String> title,
                   Optional<String> medium,
                   Optional<Integer> yearCreated,
                   Optional<Long> artistId) {

        title.ifPresent(aTitle -> this.title = aTitle);
        medium.ifPresent(aMedium -> this.medium = aMedium);
        yearCreated.ifPresent(aYearCreated -> this.yearCreated = aYearCreated);
        artistId.ifPresent(aArtistId -> this.artistId = aArtistId);
    }
}
