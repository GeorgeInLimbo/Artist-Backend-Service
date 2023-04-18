package com.georgeclam.limbo.artwork;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/****************************************************************************
 * <b>Title</b>: ArtworkController.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> ArtworkController class, which allows the Client to communicate with the database
 * via the ArtworkService class.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    /**
     * Gets a List of Artwork. Includes optional parameters that can be included in the query
     * parameters for more specific requests. If no optional query parameters are provided, this
     * method will get all Artwork from the database.
     * <p>
     * This method utilizes a constructor that exists in the ArtworkSearchDTO class.
     *
     * @param title
     * @param medium
     * @param yearCreated
     * @param artistId
     * @return List of Artwork
     */
    @GetMapping("/artwork")
    public List<Artwork> getWorks(
            @RequestParam Optional<String> title,
            @RequestParam Optional<String> medium,
            @RequestParam Optional<Integer> yearCreated,
            @RequestParam Optional<Long> artistId) {
        // filters response by using an && relationship
        log.info("getWorks was executed");
        ArtworkSearchDTO artwork = new ArtworkSearchDTO(title, medium, yearCreated, artistId);
        return artworkService.getArtwork(artwork);
    }

    /**
     * Gets a specific Artwork instance according to the provided artworkId.
     *
     * @param id
     * @return the specified Artwork.
     */
    @GetMapping("/artwork/{id}")
    public Artwork getWorkById(@PathVariable("id") Long id) {
        log.info("Get Artwork request was executed");
        return artworkService.getArtwork(id);
    }

    /**
     * Creates an instance of Artwork and saves it to the database. Includes validations
     * for attributes.
     *
     * @param body
     * @return The new instance of Artwork.
     */
    @PostMapping("/artwork")
    public Artwork create(@Valid @RequestBody Map<String, String> body) {
        log.info("Request to add new Artwork has been executed");
        return artworkService.createArtwork(body);
    }

    /**
     * Updates a specific instance of Artwork according to the provided artworkId.
     *
     * @param id
     * @param artwork
     * @return The updated instance of Artwork saved to the database.
     */
    @PutMapping("/artwork/{id}")
    public Artwork updateWork(@PathVariable("id") Long id, @RequestBody Artwork artwork) {
        log.info("A request to update artwork has been executed.");
        return artworkService.updateArtwork(id, artwork);
    }

    /**
     * Deletes a specific instance of Artwork according to the provided artworkId.
     *
     * @param id
     */
    @DeleteMapping("/artwork/{id}")
    public void deleteWork(@PathVariable("id") Long id) {
        log.info("A request to delete artwork has been executed");
        artworkService.deleteArtwork(id);
    }

    /**
     * Gets a specific instances of Artwork according to the provided artistId.
     * Includes an optional query parameter for the medium which the artist uses.
     *
     * @param artistId
     * @param medium
     * @return List of Artwork that meets the criteria of the Client.
     */
    @GetMapping("/artists/{artistId}")
    public List<Artwork> findWorkByArtistId(
            @PathVariable Long artistId,
            @RequestParam Optional<String> medium) {
        // Able to add additional params to search by artistId
        log.info("findWorksByMediumAndArtistId request was made by a client.");
        return artworkService.getArtworkByArtist(artistId, medium);
    }

    // TODO: Include custom SQL Query method.
    //    @GetMapping("/artists/artists-with-artwork")
    //    public List<Artwork> findArtistName() {
    //        return artworkService
    //    }
}