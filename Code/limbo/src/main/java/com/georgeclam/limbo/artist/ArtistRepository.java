package com.georgeclam.limbo.artist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    // This repo interface provides basic CRUD operation for the entity (Artist)
}
