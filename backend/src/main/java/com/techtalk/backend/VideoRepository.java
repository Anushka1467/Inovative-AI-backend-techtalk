 package com.techtalk.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface VideoRepository extends MongoRepository<Video, String> {
    
    // Custom method if you want to filter videos by tags manually
    List<Video> findByTagsIn(List<String> tags);
}
