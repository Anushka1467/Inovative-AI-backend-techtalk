package com.examplemyproject.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(Long id) {
        return videoRepository.findById(id)
            .orElseThrow(() -> new VideoNotFoundException("Video with ID " + id + " not found"));
    }

    public List<Video> getRelatedVideos(Long videoId) {
        Video video = getVideoById(videoId);
        List<String> tags = video.getTags();
        if (tags == null || tags.isEmpty()) {
            return List.of(); // Return empty list if no tags
        }
        return videoRepository.findRelatedVideosByTags(tags, videoId);
    }

    public Video saveVideo(Video video) {
          return videoRepository.save(video); // ✅ Save video to DB
    }
}
