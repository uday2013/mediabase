package com.example.mediabase;

import com.example.mediabase.movie.MoviesBean;
import com.example.mediabase.movie.MoviesInitialList;
import com.example.mediabase.podcasts.PodcastInitialList;
import com.example.mediabase.podcasts.PodcastRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private MoviesBean moviesBean;
    private PodcastRepository podcastRepository;
    private MoviesInitialList moviesInitialList;
    private PodcastInitialList podcastInitialList;

    //moviesInitialList.asList().forEach(moviesBean::addMovie);

    public RootController(MoviesBean moviesBean, PodcastRepository podcastRepository,MoviesInitialList moviesInitialList,PodcastInitialList podcastInitialList) {
        this.moviesBean = moviesBean;
        this.podcastRepository = podcastRepository;
        this.moviesInitialList = moviesInitialList;
        this.podcastInitialList = podcastInitialList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {

        moviesInitialList.asList().forEach(moviesBean::addMovie);

        model.put("movies", moviesBean.getMovies());

       podcastInitialList.asList().forEach(podcastRepository::save);
        model.put("podcasts", podcastRepository.findAll());

        return "setup";
    }

}
