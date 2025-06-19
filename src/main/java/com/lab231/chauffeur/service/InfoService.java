package com.lab231.chauffeur.service;

import com.lab231.chauffeur.model.InfoEntry;
import com.lab231.chauffeur.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    @Autowired
    private InfoRepository infoRepository;

    public InfoEntry findByCode(String code) {
        InfoEntry entry = infoRepository.findByCode(code).orElse(null);
        return entry;
    }
} 