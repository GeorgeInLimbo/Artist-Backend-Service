package com.georgeclam.limbo.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepo;

//    public void saveArtist(String name) {
//        Artist artist = new Artist();
//        artist.setName(name);
//        artistRepo.save(name);
//    }
}
