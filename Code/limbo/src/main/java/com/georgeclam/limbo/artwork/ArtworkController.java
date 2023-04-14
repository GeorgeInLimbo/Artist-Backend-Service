package com.georgeclam.limbo.artwork;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ArtworkController {

    @Autowired
    ArtworkRepository artworkRepo;

    @GetMapping("/artwork")
    public List<Artwork> getWorks() {
        log.info("Get All Works request was executed");
        return artworkRepo.findAll();
    }

    @GetMapping("/artwork/{id}")
    public Artwork getWork(@PathVariable("id") Long id) {
        log.info("Get Artwork request was executed");
        Optional<Artwork> findArtwork = artworkRepo.findById(id);
        if (findArtwork.isEmpty()) return null;
        return findArtwork.get();
    }

    @PostMapping("create-artwork")
    public Artwork create(@Valid @RequestBody Map<String, String> body) {
        log.info("Request to add new Artwork has been executed");
        String title = body.get("title");
        String medium = body.get("medium");
        Integer yearCreated = Integer.parseInt(body.get("yearCreated"));
        Long artistId = Long.parseLong(body.get("artistId"));

        Artwork work = new Artwork(title, medium, yearCreated, artistId);
        return artworkRepo.save(work);
    }

    @PutMapping("/update-artwork/{id}")
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

    @DeleteMapping("/delete-artwork/{id}")
    public Artwork deleteWork(@PathVariable("id") Long id) {
        log.info("A request to delete artwork has been executed");
        Optional<Artwork> artworkToDeleteOptional = this.artworkRepo.findById(id);
        if (!artworkToDeleteOptional.isPresent()) return null;
        Artwork artworkToDelete = artworkToDeleteOptional.get();
        this.artworkRepo.delete(artworkToDelete);
        return artworkToDelete;
    }

    @GetMapping("/medium/{medium}")
    public List<Artwork> findWorkByMedium(
         @PathVariable(value = "medium") String medium) {
        log.info("findWorkByMedium request was made by a client.");
        return medium != null
            ? this.artworkRepo.findByMedium(medium)
            : new ArrayList<>();
    }

    @GetMapping("/medium/{medium}/{artistId}")
    public List<Artwork> findWorkByMediumAndArtistId(
            @PathVariable(value = "medium", required = false) String medium,
            @PathVariable(value = "artistId", required = false) Long id) {

        log.info("findWorksByMediumAndArtistId request was made by a client.");

        if (medium != null && id != null) {
            return this.artworkRepo.findByMediumAndArtistId(medium, id);
        } else if (medium != null) {
            return this.artworkRepo.findByMedium(medium);
        } else if (id != null) {
            return this.artworkRepo.findByArtistId(id);
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/work-by-artist/{artistId}")
    public List<Artwork> findWorkByArtist(
        @PathVariable(value = "artistId") Long id) {
        log.info("findWorkByArtist has been run");
        return id != null
            ? this.artworkRepo.findByArtistId(id)
            : new ArrayList<>();
    }
}
