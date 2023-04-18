package com.georgeclam.limbo.artist;

import org.springframework.data.jpa.repository.JpaRepository;

/****************************************************************************
 * <b>Title</b>: ArtistRepository.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> ArtistRepository class that serves as an abstraction layer to allow the application
 * to leverage the Spring JPA methods to communicate with the database.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
