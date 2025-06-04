package com.examplemyproject.demo;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ElementCollection;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    private LocalDate publishDate;
    @ElementCollection
    private List<String> tags;

     public Video() {
    }
     

    public Video(Long id, String title, String description, String url, LocalDate publishDate, List<String> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.publishDate = publishDate;
        this.tags = tags;
    }
}
