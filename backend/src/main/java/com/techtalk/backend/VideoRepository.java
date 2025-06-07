package com.techtalk.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {

    // Find videos that contain any of the given tags, excluding the one with the specified ID
    @Query("{ 'tags': { $in: ?0 }, '_id': { $ne: ?1 } }")
    List<Video> findRelatedVideosByTags(List<String> tags, String videoId);

    // Optional: Simple method to find videos by matching any tag (no exclusion)
    List<Video> findByTagsIn(List<String> tags);
}
