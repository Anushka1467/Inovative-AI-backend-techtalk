package com.techtalk.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(String id) {
        return videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
    }

    public List<Video> getRelatedVideos(String id) {
        Video currentVideo = getVideoById(id); // throws if not found
        return videoRepository.findRelatedVideosByTags(currentVideo.getTags(), id);
    }

    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }
}
