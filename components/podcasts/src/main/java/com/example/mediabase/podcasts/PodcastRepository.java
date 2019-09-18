package com.example.mediabase.podcasts;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PodcastRepository extends CrudRepository<Podcast, Long> {

    Optional<Podcast> findById(Long id);
}
