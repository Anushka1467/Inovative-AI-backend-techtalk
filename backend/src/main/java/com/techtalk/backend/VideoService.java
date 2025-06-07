 package com.techtalk.backend;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(String id) {
        return videoRepository.findById(id)
            .orElseThrow(() -> new VideoNotFoundException("Video with ID " + id + " not found"));
    }

    public List<Video> getRelatedVideos(String videoId) {
        Video video = getVideoById(videoId);
        List<String> tags = video.getTags();
        if (tags == null || tags.isEmpty()) {
            return List.of(); // Return empty list if no tags
        }

        // Fetch all videos with matching tags
        List<Video> matchingVideos = videoRepository.findByTagsIn(tags);

        // Filter out the video itself
        return matchingVideos.stream()
                .filter(v -> !v.getId().equals(videoId))
                .collect(Collectors.toList());
    }

    public Video saveVideo(Video video) {
        return videoRepository.save(video); // Save video to MongoDB
    }
}
