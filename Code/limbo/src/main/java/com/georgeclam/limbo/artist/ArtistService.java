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


//    @DeleteMapping("/people/{id}")
//    public Person deletePerson(@PathVariable("id") Integer id) {
//        Optional<Person> personToDeleteOptional = this.personRepository.findById(id);
//        if (!personToDeleteOptional.isPresent()) {
//            return null;
//        }
//        Person personToDelete = personToDeleteOptional.get();
//        this.personRepository.delete(personToDelete);
//        return personToDelete;
//    }