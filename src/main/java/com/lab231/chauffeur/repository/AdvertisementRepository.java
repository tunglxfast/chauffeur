package com.lab231.chauffeur.repository;

import com.lab231.chauffeur.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
} 