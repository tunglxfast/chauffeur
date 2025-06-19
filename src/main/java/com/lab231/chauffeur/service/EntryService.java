package com.lab231.chauffeur.service;

import com.lab231.chauffeur.model.Entry;
import com.lab231.chauffeur.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> findTop3ByOrderByPublishedDateDesc() {
        return entryRepository.findTop3ByOrderByPublishedDateDesc();
    }
} 