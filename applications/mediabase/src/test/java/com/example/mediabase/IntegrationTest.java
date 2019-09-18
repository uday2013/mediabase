package com.example.mediabase;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class IntegrationTest {

    @Test
    public void podcastTest() {

        RestTemplate restTemplate = new RestTemplate();

        String homePage = restTemplate.getForObject(url("/"), String.class);

        assertThat(homePage, containsString("Please select one of the following links:"));

        String setupPage = restTemplate.getForObject(url("/setup"), String.class);

        assertThat(setupPage, containsString("TED Radio Hour"));
        assertThat(setupPage, containsString("Fresh Air"));

        String podcastsPage = restTemplate.getForObject(url("/podcasts"), String.class);

        assertThat(podcastsPage, containsString("TED Radio Hour"));
        assertThat(podcastsPage, containsString("Fresh Air"));
    }

    private String url(String path) {
        String baseUrl = "http://localhost:8080/";
        String envUrl = System.getenv("MEDIABASE_URL");

        if (envUrl != null && !envUrl.isEmpty()) {
            baseUrl = envUrl;
        }

        return baseUrl + path;
    }
}
