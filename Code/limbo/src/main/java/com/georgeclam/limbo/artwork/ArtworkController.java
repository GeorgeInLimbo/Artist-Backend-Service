package com.georgeclam.limbo.artwork;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return artworkRepo.findById(id).get();
    }

    @PostMapping("create-artwork")
    public Artwork create(@Valid @RequestBody Map<String, String> body) {
        log.info("Request to add new Artwork has been executed");
        String title = body.get("title");
        String medium = body.get("medium");
        Integer yearCreated = Integer.parseInt(body.get("yearCreated"));
        String path = body.get("path");

        Artwork work = new Artwork(title, medium, yearCreated, path);
        return artworkRepo.save(work);
    }

    @PutMapping("/update-artwork/{id}")
    public Artwork updateWork(@PathVariable("id") Long id, @RequestBody Artwork w) {
        log.info("A request to update artwork has been executed.");
        Optional<Artwork> artworkToUpdateOptional = this.artworkRepo.findById(id);

        if (!artworkToUpdateOptional.isPresent()) return null;
        Artwork artworkToUpdate = artworkToUpdateOptional.get();

        if (w.getTitle() != null) artworkToUpdate.setTitle(w.getTitle());
        if (w.getMedium() != null) artworkToUpdate.setTitle(w.getMedium());
        if (w.getYearCreated() != null) artworkToUpdate.setYearCreated(w.getYearCreated());
        if (w.getPath() != null) artworkToUpdate.setPath(w.getPath());

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
}
