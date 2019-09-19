package com.example.mediabase;

import com.example.mediabase.moviesui.MovieClient;
import com.example.mediabase.moviesui.MoviesInitialList;
import com.example.mediabase.podcastui.PodcastClient;
import com.example.mediabase.podcastui.PodcastInitialList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    //private MoviesBean moviesBean;
    private MovieClient movieClient;
    //private PodcastRepository podcastRepository;
    private PodcastClient podcastClient;
    private MoviesInitialList moviesInitialList;
    private PodcastInitialList podcastInitialList;

    //moviesInitialList.asList().forEach(moviesBean::addMovie);

    public RootController(MovieClient movieClient, PodcastClient podcastClient,MoviesInitialList moviesInitialList,PodcastInitialList podcastInitialList) {
        this.movieClient = movieClient;
        this.podcastClient = podcastClient;
        this.moviesInitialList = moviesInitialList;
        this.podcastInitialList = podcastInitialList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {

        moviesInitialList.asList().forEach(movieClient::create);
        model.put("movies", movieClient.getAll());
        podcastInitialList.asList().forEach(podcastClient::save);
        model.put("podcasts", podcastClient.findall());
        return "setup";
    }

}
