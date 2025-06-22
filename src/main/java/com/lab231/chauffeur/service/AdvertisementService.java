package com.lab231.chauffeur.service;

import com.lab231.chauffeur.model.Advertisement;
import com.lab231.chauffeur.repository.AdvertisementRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public Advertisement getFirstAdvertisement() {
        List<Advertisement> adList = advertisementRepository.findAll();
        if (adList.isEmpty()){
            return null;
        }
        return adList.get(0);
    }
} 