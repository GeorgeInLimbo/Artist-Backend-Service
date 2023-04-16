package com.georgeclam.limbo.artwork;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

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

    @GetMapping("/artwork/{id}")
    public Artwork getWorkById(@PathVariable("id") Long id) {
        log.info("Get Artwork request was executed");
        return artworkService.getArtwork(id);
    }

    @PostMapping("/artwork")
    public Artwork create(@Valid @RequestBody Map<String, String> body) {
        log.info("Request to add new Artwork has been executed");
        return artworkService.createArtwork(body);
    }

    @PutMapping("/artwork/{id}")
    public Artwork updateWork(@PathVariable("id") Long id, @RequestBody Artwork artwork) {
        log.info("A request to update artwork has been executed.");
        return artworkService.updateArtwork(id, artwork);
    }

    @DeleteMapping("/artwork/{id}")
    public void deleteWork(@PathVariable("id") Long id) {
        log.info("A request to delete artwork has been executed");
        artworkService.deleteArtwork(id);
    }

    @GetMapping("/artists/{artistId}")
    public List<Artwork> findWorkByArtistId(
            @PathVariable Long artistId,
            @RequestParam Optional<String> medium) {
        // Able to add additional params to search by artistId
        log.info("findWorksByMediumAndArtistId request was made by a client.");
        return artworkService.getArtworkByArtist(artistId, medium);
    }

//    @GetMapping("/artists/artists-with-artwork")
//    public List<Artwork> findArtistName() {
//        return artworkService
//    }
}
