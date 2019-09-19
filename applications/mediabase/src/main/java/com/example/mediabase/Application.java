package com.example.mediabase;

import com.example.mediabase.moviesui.ActionServlet;
import com.example.mediabase.moviesui.MovieClient;
import com.example.mediabase.podcastui.PodcastClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    @Value("${movies.ms.url}")
    private String moviesURL;
    @Value("${podcasts.ms.url}")
    private String podcastsURL;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean registerActionServlet(ActionServlet actionServlet) {
        return new ServletRegistrationBean(actionServlet, "/moviefun/*");
    }

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public MovieClient movieClient(RestOperations restOperations) {
        return new MovieClient(moviesURL, restOperations);
    }

    @Bean
    public PodcastClient podcastClient(RestOperations restOperations) {
        return new PodcastClient(podcastsURL, restOperations);

    }
}
