package com.lab231.chauffeur.service;

import com.lab231.chauffeur.model.Entry;
import com.lab231.chauffeur.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> findTop3ByOrderByPublishedDateDesc() {
        return entryRepository.findTop3ByOrderByPublishedDateDesc();
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public List<String> getAllImageUrls() {
        List<String> imageList = new ArrayList<>();
        List<Entry> entries = entryRepository.findAll();
        String url = null;
        for (Entry entry: entries) {
            url = entry.getImageUrl();
            if (url != null && !url.isEmpty()) {
                imageList.add(url);
            }
        }
        return imageList;
    }
} 