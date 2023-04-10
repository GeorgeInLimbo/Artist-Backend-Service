package com.georgeclam.limbo.artist;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class ArtistController {

    @Autowired
    ArtistRepository artistRepo;

    @GetMapping("/artists")
    public List<Artist> getArtists() {
       return artistRepo.findAll();
    }

    @GetMapping("artist/{id}")
    public Artist getArtist(@PathVariable("id") Long id) {
        return artistRepo.findById(id).get();
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteRow(@PathVariable("id") Long id) {
        // If the queried artist exists, delete the row and return true
        // If the queried artist doesn't exist, delete the row
        if(!artistRepo.findById(id).equals(Optional.empty())) {
            artistRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public Artist updateArtist(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
        Artist artist = artistRepo.findById(id).get();
        artist.setName(body.get("name"));
        artist.setEmail(body.get("email"));
        artist.setPassword(body.get("password"));
        artistRepo.save(artist);
        return artist;
    }

    @PostMapping("create")
    public Artist create(@Valid @RequestBody Map<String, String> body) {
        String name = body.get("name");
        String password = body.get("password");
        String email = body.get("password");

        Artist newArtist = new Artist(name, password, email);
        return artistRepo.save(newArtist);
    }
}
