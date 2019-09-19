package com.example.mediabase.moviesui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MoviesInitialList {

    public List<MovieUI> asList() {
        return Arrays.asList(new MovieUI("Wedding Crashers", "David Dobkin", "Comedy", 7, 2005),
                new MovieUI("Starsky & Hutch", "Todd Phillips", "Action", 6, 2004),
                new MovieUI("Shanghai Knights", "David Dobkin", "Action", 6, 2003),
                new MovieUI("I-Spy", "Betty Thomas", "Adventure", 5, 2002),
                new MovieUI("The Royal Tenenbaums", "Wes Anderson", "Comedy", 8, 2001),
                new MovieUI("Zoolander", "Ben Stiller", "Comedy", 6, 2001),
                new MovieUI("Shanghai Noon", "Tom Dey", "Comedy", 7, 2000)

        );
    }
}