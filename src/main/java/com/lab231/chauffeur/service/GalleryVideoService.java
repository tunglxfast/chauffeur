package com.lab231.chauffeur.service;

import com.lab231.chauffeur.model.GalleryVideo;
import com.lab231.chauffeur.repository.GalleryVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryVideoService {
    @Autowired
    private GalleryVideoRepository galleryVideoRepository;

    public String getMainVideo() {
        List<GalleryVideo> videos = galleryVideoRepository.findAll();
        if (!videos.isEmpty()) {
            return videos.get(videos.size() - 1).getVideoUrl();
        } else {
            return null;
        }
    }
}
