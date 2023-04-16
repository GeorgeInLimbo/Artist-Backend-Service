package com.georgeclam.limbo.artwork;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

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
