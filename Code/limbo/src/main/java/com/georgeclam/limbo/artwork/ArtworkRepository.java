package com.georgeclam.limbo.artwork;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/****************************************************************************
 * <b>Title</b>: ArtworkRepository.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> The ArtworkRepository class serves as an abstraction layer for the Artwork Entity, allowing
 * the application to leverage the functionality of Spring JPA.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

    /**
     * Gets instances of Artwork according to a provided artistId.
     *
     * @param id
     * @return A list of Artwork according to the artistId provided in the request.
     */
    List<Artwork> findByArtistId(Long id);

    /**
     * Gets instances of Artwork according to a provided artist Id. Also includes
     * an optional parameter to specify the request according to the medium of the
     * Artwork.
     *
     * @param medium
     * @param artistId
     * @return A list of Artwork that meet the criteria of the request.
     */
    List<Artwork> findByMediumAndArtistId(String medium, Long artistId);

    // TODO: Add a declaration for a custom query to the database using the @Query annotation
    //    @Query(value =
    //           "SELECT artwork.title, artwork.artistId, artist.name " +
    //           "FROM artwork " +
    //           "JOIN artist ON artwork.artistId=artist.id;",
    //            nativeQuery = true)
    //    List<Artwork> findArtistName();
}
