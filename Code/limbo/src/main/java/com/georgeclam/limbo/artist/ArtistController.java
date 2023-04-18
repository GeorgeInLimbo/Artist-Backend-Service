package com.georgeclam.limbo.artist;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: ArtistController.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> ArtistController class, which allows the Client to interact with the database.
 * Communicates with the database through the ArtistService class.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/


// TODO: Customize HTTP Response Codes for each method, create custom queries, look into exception handling

@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class ArtistController {

    @Autowired
    ArtistService artistService;

    /**
     * Gets all artists from the database.
     *
     * @return A List of all Artists in the database
     */
    @GetMapping("/artists")
    public List<Artist> getArtists() {
        log.info("'Get All Artists' request was executed.");
        return artistService.getArtists();
    }

    /**
     * Gets a specific artist from the database according to their ID.
     *
     * @param id
     * @return A specific, singular Artist.
     */
    @GetMapping("artist/{id}")
    public Artist getArtist(@PathVariable("id") Long id) {
        log.info("Get Artist by ID was executed.");
        return artistService.getArtistById(id);
    }

    /**
     * Deletes a specific instance of an Artist from the database.
     *
     * @param id
     * @return If the Artist was deleted, the method returns true.
     */
    @DeleteMapping("/remove/{id}")
    public boolean deleteRow(@PathVariable("id") Long id) {
        log.info("Request to delete a row from the Artist table was executed.");
        return artistService.deleteArtist(id);
    }

    /**
     * Updates the data in the database for a specific Artist.
     *
     * @param id
     * @param body
     * @return Returns the Artist with the updated data.
     */
    // This method requires that the client completes all fields.
    @PutMapping("/update/{id}")
    public Artist updateArtist(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
        log.info("A request to update an Artists' information was executed.");
        return artistService.updateArtistById(id, body);
    }

    /**
     * Creates a new Artist and saves it to the database.
     *
     * @param body
     * @return the information provided for the new Artist that's been added to the database.
     */
    @PostMapping("create")
    public Artist create(@Valid @RequestBody Map<String, String> body) {
        log.info("A request to create a new Artist was executed");
        return artistService.createArtist(body);
    }

}
