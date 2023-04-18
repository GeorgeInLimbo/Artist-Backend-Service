package com.georgeclam.limbo.artwork;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Optional;

/****************************************************************************
 * <b>Title</b>: ArtworkSearchDTO.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> Class that provides the ability to search for Artwork according to optional
 * parameters provided by the Client in their requests. Allows for more specific requests.
 * Represents a search payload where each field is an optional filter applied to
 * queries on the artwork resource set.
 *
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/
@Getter
@Setter
@ToString
public class ArtworkSearchDTO {
    private Long artworkId;
    private String title;
    private Long artistId;
    private String medium;
    private Integer yearCreated;

    /**
     * Constructor that allows for optional values for columns in the table.
     * @param title
     * @param medium
     * @param yearCreated
     * @param artistId
     */
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
