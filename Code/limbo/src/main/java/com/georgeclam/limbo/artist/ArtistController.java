package com.georgeclam.limbo.artist;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

// TODO: Customize HTTP Response Codes for each method, create advanced queries and custom queries, look into exception handling

@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/artists")
    public List<Artist> getArtists() {
        log.info("'Get All Artists' request was executed.");
        return artistService.getArtists();
    }

    @GetMapping("artist/{id}")
    public Artist getArtist(@PathVariable("id") Long id) {
        log.info("Get Artist by ID was executed.");
        return artistService.getArtistById(id);
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteRow(@PathVariable("id") Long id) {
        log.info("Request to delete a row from the Artist table was executed.");
        return artistService.deleteArtist(id);
    }

    // This method requires that the client completes all fields.
    @PutMapping("/update/{id}")
    public Artist updateArtist(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
        log.info("A request to update an Artists' information was executed.");
        return artistService.updateArtistById(id, body);
    }

    @PostMapping("create")
    public Artist create(@Valid @RequestBody Map<String, String> body) {
        log.info("A request to create a new Artist was executed");
        return artistService.createArtist(body);
    }

}
