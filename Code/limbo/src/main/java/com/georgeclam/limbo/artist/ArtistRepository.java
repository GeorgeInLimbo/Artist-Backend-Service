package com.georgeclam.limbo.artist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    // Long is the datatype of our ID
    // This repo interface provides basic CRUD operation for the entity (Artist)
}
