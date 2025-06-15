package com.lab231.chauffeur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab231.chauffeur.model.InfoEntry;

public interface InfoRepository extends JpaRepository<InfoEntry, String> {
    InfoEntry findByCode(String code);
}
