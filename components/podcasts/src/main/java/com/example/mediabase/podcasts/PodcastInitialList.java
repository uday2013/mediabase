package com.example.mediabase.podcasts;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PodcastInitialList {

    public List<Podcast>  asList() {
        return Arrays.asList(new Podcast("Wait Wait...Don't Tell Me!",
                "NPR's weekly current events quiz.",
                "https://www.npr.org/programs/wait-wait-dont-tell-me/"),
                new Podcast("TED Radio Hour",
                        "Guy Raz explores the emotions, insights, and discoveries that make us human.",
                        "https://www.npr.org/programs/ted-radio-hour/"),
                new Podcast("Fresh Air",
                        "Hosted by Terry Gross, this show features intimate conversations with today's biggest luminaries.",
                        "https://www.npr.org/programs/fresh-air/"),
                new Podcast("NPR Politics Podcast",
                        "The NPR Politics Podcast is where NPR's political reporters talk to you like they talk to each other.",
                        "https://www.npr.org/sections/politics/")

        );
    }
}