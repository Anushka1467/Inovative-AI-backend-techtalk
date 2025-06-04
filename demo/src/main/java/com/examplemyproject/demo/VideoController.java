 package com.examplemyproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping
    public List<Video> getAllVideos() {
        return (List<Video>) videoRepository.findAll();
    }

    @PostMapping
    public Video addVideo(@RequestBody Video video) {
        return videoRepository.save(video);
    }
}
