package com.techtalk.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class TechtalkApplication {
    public static void main(String[] args) {
        SpringApplication.run(TechtalkApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(VideoRepository repository) {
        return args -> {
            repository.save(new Video(null, "Intro to Spring Boot", "Basics of Spring Boot", "http://example.com/1",
                    LocalDate.now(), Arrays.asList("Spring", "Java")));

            repository.save(new Video(null, "JPA Crash Course", "Quick intro to JPA", "http://example.com/2",
                    LocalDate.now(), Arrays.asList("JPA", "Database")));

            repository.save(new Video(null, "Spring Boot Testing", "Video on unit testing in Spring Boot",
                    "http://example.com/3", LocalDate.of(2025, 6, 5), Arrays.asList("Spring", "Testing")));
        };
    }
}
