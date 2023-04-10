package com.georgeclam.limbo.artist;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ArtistController {

    @GetMapping("/test")
    public String conductTest() {
        return "This is a test";
    }
}
