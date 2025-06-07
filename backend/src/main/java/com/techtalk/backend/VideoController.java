package com.techtalk.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    // Get all videos
    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    // Get video by ID
    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable String id) {
        try {
            Video video = videoService.getVideoById(id);
            return ResponseEntity.ok(video);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get related videos by tags (excluding the original video)
    @GetMapping("/{id}/related")
    public ResponseEntity<List<Video>> getRelatedVideos(@PathVariable String id) {
        try {
            List<Video> relatedVideos = videoService.getRelatedVideos(id);
            return ResponseEntity.ok(relatedVideos);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a new video
    @PostMapping
    public ResponseEntity<Video> addVideo(@RequestBody Video video) {
        Video savedVideo = videoService.saveVideo(video);
        return ResponseEntity.ok(savedVideo);
    }
}
