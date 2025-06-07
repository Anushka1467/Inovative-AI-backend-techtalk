package com.techtalk.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "videos")  // Maps to MongoDB collection named 'videos'
@Data                           // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor              // Generates no-arg constructor
@AllArgsConstructor             // Generates full-arg constructor
public class Video {

    @Id
    private String id;

    private String title;
    private String description;
    private String url;
    private LocalDate publishDate;
    private List<String> tags;
}
