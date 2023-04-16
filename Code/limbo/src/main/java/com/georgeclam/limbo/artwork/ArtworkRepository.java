package com.georgeclam.limbo.artwork;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    List<Artwork> findByArtistId(Long id);
    List<Artwork> findByMediumAndArtistId(String medium, Long artistId);

//    @Query(value =
//           "SELECT artwork.title, artwork.artistId, artist.name " +
//           "FROM artwork " +
//           "JOIN artist ON artwork.artistId=artist.id;",
//            nativeQuery = true)
//    List<Artwork> findArtistName();
}
