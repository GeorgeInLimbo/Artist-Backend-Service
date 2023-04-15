package com.georgeclam.limbo.artwork;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class ArtworkController {

    @Autowired
    ArtworkRepository artworkRepo;

    @GetMapping("/artwork")
    public List<Artwork> getWorks(
            @RequestParam Optional<String> title,
            @RequestParam Optional<String> medium,
            @RequestParam Optional<Integer> yearCreated,
            @RequestParam Optional<Long> artistId) {
        // Query Parameters are conjunctions (filter with an && relationship)
        log.info("getWorks was executed");

        return artworkRepo.findAll(Example.of(
                new Artwork(title, medium, yearCreated, artistId)));
    }

    @GetMapping("/artwork/{id}")
    public Artwork getWork(@PathVariable("id") Long id) {
        log.info("Get Artwork request was executed");
        Optional<Artwork> findArtwork = artworkRepo.findById(id);
        if (findArtwork.isEmpty()) return null;
        return findArtwork.get();
    }

    @PostMapping("/artwork")
    public Artwork create(@Valid @RequestBody Map<String, String> body) {

        log.info("Request to add new Artwork has been executed");

        String title = body.get("title");
        String medium = body.get("medium");
        Integer yearCreated = Integer.parseInt(body.get("yearCreated"));
        Long artistId = Long.parseLong(body.get("artistId"));
        log.info(yearCreated.toString());
        Artwork work = new Artwork(title, medium, yearCreated, artistId);

        return artworkRepo.save(work);
    }

    @PutMapping("/artwork/{id}")
    public Artwork updateWork(@PathVariable("id") Long id, @RequestBody Artwork w) {
        log.info("A request to update artwork has been executed.");
        Optional<Artwork> artworkToUpdateOptional = this.artworkRepo.findById(id);

        if (artworkToUpdateOptional.isEmpty()) return null;
        Artwork artworkToUpdate = artworkToUpdateOptional.get();

        if (w.getTitle() != null) artworkToUpdate.setTitle(w.getTitle());
        if (w.getMedium() != null) artworkToUpdate.setMedium(w.getMedium());
        if (w.getArtistId() != null) artworkToUpdate.setArtistId(w.getArtistId());
        if (w.getYearCreated() != null) artworkToUpdate.setYearCreated(w.getYearCreated());

        Artwork updatedArtwork = this.artworkRepo.save(artworkToUpdate);
        return updatedArtwork;
    }

    @DeleteMapping("/artwork/{id}")
    public Artwork deleteWork(@PathVariable("id") Long id) {
        log.info("A request to delete artwork has been executed");
        Optional<Artwork> artworkToDeleteOptional = this.artworkRepo.findById(id);
        if (!artworkToDeleteOptional.isPresent()) return null;
        Artwork artworkToDelete = artworkToDeleteOptional.get();
        this.artworkRepo.delete(artworkToDelete);
        return artworkToDelete;
    }

    @GetMapping("/artists/{artistId}")
    public List<Artwork> findWorkByArtistIdAndMedium(
            @PathVariable Long artistId,
            // Provides optional query parameter, i.e
            //
            // /artists/1
            // /artists/1?medium=boogers
            @RequestParam Optional<String> medium) {

        log.info("findWorksByMediumAndArtistId request was made by a client.");

        if (medium.isPresent() && artistId != null) {
            return this.artworkRepo.findByMediumAndArtistId(medium.get(), artistId);
//        } else if (medium.isPresent()) {
//            return this.artworkRepo.findByMedium(medium);
        } else if (artistId != null) {
            return this.artworkRepo.findByArtistId(artistId);
        } else {
            return new ArrayList<>();
        }
    }

//    @GetMapping("/artists/{artistId}/{medium}")
//    public List<Artwork> findWorkByArtistIdAndMedium(
//            @PathVariable(value = "medium", required = false) String medium,
//            @PathVariable(value = "artistId", required = false) Long id) {
//
//        log.info("findWorksByMediumAndArtistId request was made by a client.");
//
//        if (medium != null && id != null) {
//            return this.artworkRepo.findByMediumAndArtistId(medium, id);
//        } else if (medium != null) {
//            return this.artworkRepo.findByMedium(medium);
//        } else if (id != null) {
//            return this.artworkRepo.findByArtistId(id);
//        } else {
//            return new ArrayList<>();
//        }
//    }

    @GetMapping("/artist/{artistId}")
    public List<Artwork> findWorkByArtist(
        @PathVariable(value = "artistId") Long id) {
        log.info("findWorkByArtist has been run");
        return id != null
            ? this.artworkRepo.findByArtistId(id)
            : new ArrayList<>();
    }
}
