package com.georgeclam.limbo.artist;

import com.georgeclam.limbo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/****************************************************************************
 * <b>Title</b>: ArtistService.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> The ArtistService class contains the business logic for the Entity.
 * It serves as a mediator between the ArtistController and the ArtistRepository.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepo;

    /**
     * Extracts all Artists from the database.
     *
     * @return All instances of Artist in the database.
     */
    public List<Artist> getArtists() {
        return artistRepo.findAll();
    }

    /**
     * Extracts a specific Artist from the database according to their ID.
     *
     * @param id
     * @return A specific instance of Artist.
     */
    public Artist getArtistById(Long id) {
        return artistRepo.findById(id).orElseThrow(
                () -> new NotFoundException("The Artist with ID: " + id + " was not found."));
    }

    /**
     * Deletes an Artist from the database according to the ID pass into the method.
     *
     * @param id
     * @return true if the Artist was removed from the database.
     */
    public boolean deleteArtist(Long id) {
        if (!artistRepo.findById(id).equals(Optional.empty())) {
            artistRepo.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Adds a new instance of an Artist to the database.
     *
     * @param body
     * @return the new instance of Artist that has been added to the database.
     */
    public Artist createArtist(Map<String, String> body) {
        String name = body.get("name");
        String password = body.get("password");
        String email = body.get("email");

        Artist newArtist = new Artist(name, password, email);
        return artistRepo.save(newArtist);
    }

    /**
     * Updates the values of an Artist instance in the database.
     *
     * @param id
     * @param body
     * @return The information for the updated Artist.
     */
    public Artist updateArtistById(Long id, Map<String, String> body) {
        Artist artist = artistRepo.findById(id).orElseThrow(
                () -> new NotFoundException("The Customer with ID: " + id + " was not found."));

        artist.setName(body.get("name"));
        artist.setEmail(body.get("email"));
        artist.setPassword(body.get("password"));

        artistRepo.save(artist);
        return artist;
    }
}
