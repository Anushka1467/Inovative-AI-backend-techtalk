package com.techtalk.backend;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "videos")  // Specifies the MongoDB collection name
@Data
public class Video {

    @Id
    private String id; // MongoDB uses String id (ObjectId)

    private String title;
    private String description;
    private String url;
    private LocalDate publishDate;
    private List<String> tags;

    public Video() {
    }

    public Video(String id, String title, String description, String url, LocalDate publishDate, List<String> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.publishDate = publishDate;
        this.tags = tags;
    }
}
