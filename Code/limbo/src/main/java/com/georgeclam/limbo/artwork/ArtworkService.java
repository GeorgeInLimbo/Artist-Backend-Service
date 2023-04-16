package com.georgeclam.limbo.artwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ArtworkService {

    @Autowired
    private ArtworkRepository artworkRepo;

    public ArtworkService(ArtworkRepository artworkRepo) {
        this.artworkRepo = artworkRepo;
    }

    public List<Artwork> getArtworkByArtist(Long artistId, Optional<String> medium) {
        return medium.isPresent()
                ? this.artworkRepo.findByMediumAndArtistId(medium.get(), artistId)
                : this.artworkRepo.findByArtistId(artistId);
    }

    public List<Artwork> getArtwork(ArtworkSearchDTO artworkSearch) {
        Artwork artwork = new Artwork(
                artworkSearch.getTitle(),
                artworkSearch.getMedium(),
                artworkSearch.getYearCreated(),
                artworkSearch.getArtistId());
        return this.artworkRepo.findAll(Example.of(artwork));
    }

    public Artwork getArtwork(Long id) {
        Optional<Artwork> findArtwork = artworkRepo.findById(id);
        return findArtwork.orElse(null);
    }

    public Artwork createArtwork(Map<String, String> body) {
        String title = body.get("title");
        String medium = body.get("medium");
        Integer yearCreated = Integer.parseInt(body.get("yearCreated"));
        Long artistId = Long.parseLong(body.get("artistId"));

        Artwork work = new Artwork(title, medium, yearCreated, artistId);

        return artworkRepo.save(work);
    }

    public Artwork updateArtwork(Long id, Artwork w) {
        Optional<Artwork> artworkToUpdateOptional = artworkRepo.findById(id);

        if (artworkToUpdateOptional.isEmpty()) return null;
        Artwork artworkToUpdate = artworkToUpdateOptional.get();

        if (w.getTitle() != null) artworkToUpdate.setTitle(w.getTitle());
        if (w.getMedium() != null) artworkToUpdate.setMedium(w.getMedium());
        if (w.getArtistId() != null) artworkToUpdate.setArtistId(w.getArtistId());
        if (w.getYearCreated() != null) artworkToUpdate.setYearCreated(w.getYearCreated());

        return this.artworkRepo.save(artworkToUpdate);
    }

    public void deleteArtwork(Long id) {
        Optional<Artwork> artworkToDeleteOptional = artworkRepo.findById(id);
        if (artworkToDeleteOptional.isEmpty()) return;
        Artwork artworkToDelete = artworkToDeleteOptional.get();
        artworkRepo.delete(artworkToDelete);
    }
}
