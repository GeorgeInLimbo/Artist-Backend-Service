package com.georgeclam.limbo.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepo;

    public List<Artist> getArtists() {
        return artistRepo.findAll();
    }

    public Artist getArtistById(Long id) {
        return artistRepo.findById(id).get();
    }

    public boolean deleteArtist(Long id) {
        if(!artistRepo.findById(id).equals(Optional.empty())) {
            artistRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Artist createArtist(Map<String, String> body) {
        String name = body.get("name");
        String password = body.get("password");
        String email = body.get("email");

        Artist newArtist = new Artist(name, password, email);
        return artistRepo.save(newArtist);
    }

    public Artist updateArtistById(Long id, Map<String, String> body) {
        Artist artist = artistRepo.findById(id).get();
        artist.setName(body.get("name"));
        artist.setEmail(body.get("email"));
        artist.setPassword(body.get("password"));
        artistRepo.save(artist);
        return artist;
    }
}
