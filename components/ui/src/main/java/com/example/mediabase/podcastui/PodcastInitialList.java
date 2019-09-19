package com.example.mediabase.podcastui;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PodcastInitialList {

    public List<PodcastUI>  asList() {
        return Arrays.asList(new PodcastUI("Wait Wait...Don't Tell Me!",
                "NPR's weekly current events quiz.",
                "https://www.npr.org/programs/wait-wait-dont-tell-me/"),
                new PodcastUI("TED Radio Hour",
                        "Guy Raz explores the emotions, insights, and discoveries that make us human.",
                        "https://www.npr.org/programs/ted-radio-hour/"),
                new PodcastUI("Fresh Air",
                        "Hosted by Terry Gross, this show features intimate conversations with today's biggest luminaries.",
                        "https://www.npr.org/programs/fresh-air/"),
                new PodcastUI("NPR Politics Podcast",
                        "The NPR Politics Podcast is where NPR's political reporters talk to you like they talk to each other.",
                        "https://www.npr.org/sections/politics/")

        );
    }
}