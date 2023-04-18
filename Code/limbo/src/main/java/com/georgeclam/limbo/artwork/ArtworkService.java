package com.georgeclam.limbo.artwork;

import com.georgeclam.limbo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/****************************************************************************
 * <b>Title</b>: ArtworkService.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> ArtworkService class, which serves as a mediator between the ArtworkController class
 * and the ArtworkRepository class. Contains all the business logic for the Entity.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

@Service
public class ArtworkService {

    @Autowired
    private ArtworkRepository artworkRepo;

    /**
     * Dependency Injection for the ArtworkRepository handled in the constructor.
     *
     * @param artworkRepo
     */
    public ArtworkService(ArtworkRepository artworkRepo) {
        this.artworkRepo = artworkRepo;
    }

    /**
     * Gets instances of Artwork from the database according to the provided artistId. Also includes an
     * optional parameter to further specify the return according to the medium used by the specified
     * Artist.
     *
     * @param artistId
     * @param medium
     * @return List of Artwork that meets the criteria provided by the Client.
     */
    public List<Artwork> getArtworkByArtist(Long artistId, Optional<String> medium) {
        return medium.isPresent()
                ? this.artworkRepo.findByMediumAndArtistId(medium.get(), artistId)
                : this.artworkRepo.findByArtistId(artistId);
    }

    /**
     * Gets instances of Artwork. Includes optional parameters for more specific searches.
     * If no optional parameters are provided, the method will retrieve all instances of
     * Artwork from the database.
     *
     * @param artworkSearch
     * @return List of Artwork that meet the criteria of the request.
     */
    public List<Artwork> getArtwork(ArtworkSearchDTO artworkSearch) {
        Artwork artwork = new Artwork(
                artworkSearch.getTitle(),
                artworkSearch.getMedium(),
                artworkSearch.getYearCreated(),
                artworkSearch.getArtistId());
        return this.artworkRepo.findAll(Example.of(artwork));
    }

    /**
     * Gets a specific instance of Artwork according to the artworkId provided by the Client.
     *
     * @param id
     * @return A specific instance of Artwork according to the artworkId provided by the Client.
     */
    public Artwork getArtwork(Long id) {
        Optional<Artwork> findArtwork = artworkRepo.findById(id);
        return findArtwork.orElseThrow( () -> new NotFoundException(
                "The Artwork with ID: " + id + " was not found."
        ));
    }

    /**
     * Creates a new instance of Artwork and saves it to the database.
     *
     * @param body
     * @return The new instance of Artwork saved to the database.
     */
    public Artwork createArtwork(Map<String, String> body) {
        String title = body.get("title");
        String medium = body.get("medium");
        Integer yearCreated = Integer.parseInt(body.get("yearCreated"));
        Long artistId = Long.parseLong(body.get("artistId"));

        Artwork work = new Artwork(title, medium, yearCreated, artistId);

        return artworkRepo.save(work);
    }

    /**
     * Updates a specific instance of Artwork, which is passed directly into the method.
     *
     * @param id
     * @param work
     * @return The updated instance of Artwork saved to the database.
     */
    public Artwork updateArtwork(Long id, Artwork work) {
        Optional<Artwork> artworkToUpdateOptional = artworkRepo.findById(id);

        if (artworkToUpdateOptional.isEmpty()) return null;
        Artwork artworkToUpdate = artworkToUpdateOptional.get();

        if (work.getTitle() != null) artworkToUpdate.setTitle(work.getTitle());
        if (work.getMedium() != null) artworkToUpdate.setMedium(work.getMedium());
        if (work.getArtistId() != null) artworkToUpdate.setArtistId(work.getArtistId());
        if (work.getYearCreated() != null) artworkToUpdate.setYearCreated(work.getYearCreated());

        return this.artworkRepo.save(artworkToUpdate);
    }

    /**
     * Deletes a specific instance of Artwork according to the provided artworkId.
     *
     * @param id
     */
    public void deleteArtwork(Long id) {
        Optional<Artwork> artworkToDeleteOptional = artworkRepo.findById(id);
        if (artworkToDeleteOptional.isEmpty())
            throw new NotFoundException("The Artwork with ID: " + id + " has not been found.");
        Artwork artworkToDelete = artworkToDeleteOptional.get();
        artworkRepo.delete(artworkToDelete);
    }
}
