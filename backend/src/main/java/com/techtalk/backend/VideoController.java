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

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable String id) {
        try {
            Video video = videoService.getVideoById(id);
            return ResponseEntity.ok(video);
       }     catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    //  Add this method to handle related videos
    @GetMapping("/{id}/related")
    public ResponseEntity<List<Video>> getRelatedVideos(@PathVariable String id) {
       try {
            List<Video> relatedVideos = videoService.getRelatedVideos(id);
            return ResponseEntity.ok(relatedVideos);
        }   catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
      
    // Add this method for POST
    @PostMapping
    public Video addVideo(@RequestBody Video video) {
        return videoService.saveVideo(video); // you can implement saveVideo if needed
    }
}
