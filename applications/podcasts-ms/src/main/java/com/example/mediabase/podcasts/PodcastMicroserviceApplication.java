package com.example.mediabase.podcasts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PodcastMicroserviceApplication {

    public static void main(String... args) { SpringApplication.run(PodcastMicroserviceApplication.class, args);
    }

}
