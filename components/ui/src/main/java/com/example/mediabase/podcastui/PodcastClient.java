package com.example.mediabase.podcastui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

public class PodcastClient {

    private static ParameterizedTypeReference<List<PodcastUI>> podcastListType = new ParameterizedTypeReference<List<PodcastUI>>() {
    };
    private RestOperations restOperations;
    private String podcastsURL;
    private static final int CACHE_SIZE = 5;
    private final List<PodcastUI> lastRead = new ArrayList<>(CACHE_SIZE);
    private static final Logger log = LoggerFactory.getLogger(PodcastClient.class);


    public PodcastClient(String podcastsURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.podcastsURL = podcastsURL;
    }

    public void save(PodcastUI podcastUI){
        restOperations.postForEntity(podcastsURL, podcastUI, podcastUI.getClass());
    }

/*
    public List<PodcastUI> findall() {
        return restOperations.exchange(podcastsURL, HttpMethod.GET, null, podcastListType).getBody();
    }*/

    //@HystrixCommand(fallbackMethod="findallFallback")
    @HystrixCommand(fallbackMethod="findallFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public List<PodcastUI> findall() {
        List<PodcastUI> read = restOperations.exchange(podcastsURL, HttpMethod.GET, null, podcastListType).getBody();
        log.debug("Read {} podcasts from {}", read.size(), podcastsURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++)
            lastRead.add(read.get(i));
        log.debug("Copied {} podcasts into the cache", copyCount);

        return read;
    }

    public List<PodcastUI> findallFallback() {
        log.debug("Returning {} podcasts from the fallback method", lastRead.size());

        return lastRead;
    }


}

