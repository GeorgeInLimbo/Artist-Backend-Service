package com.georgeclam.limbo.artwork;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    List<Artwork> findByMedium(String medium);
    List<Artwork> findByArtistId(Long id);
    List<Artwork> findByMediumAndArtistId(String medium, Long artistId);
    List<Artwork> findByYearCreated(Integer yearCreated);
}
