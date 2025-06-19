package com.lab231.chauffeur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab231.chauffeur.model.InfoEntry;
import java.util.Optional;

public interface InfoRepository extends JpaRepository<InfoEntry, String> {
    Optional<InfoEntry> findByCode(String code);
}
