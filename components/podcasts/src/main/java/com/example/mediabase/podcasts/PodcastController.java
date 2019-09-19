package com.example.mediabase.podcasts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

    private PodcastRepository podcastRepository;

    public PodcastController(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    @PostMapping
    public ResponseEntity<Podcast> save(@RequestBody Podcast podcast) {

        podcastRepository.save(podcast);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


       @GetMapping()
       public Iterable<Podcast>  read(){
        return podcastRepository.findAll();
    }

}
