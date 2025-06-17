package com.lab231.chauffeur.repository;

import com.lab231.chauffeur.model.PageView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageViewRepository extends JpaRepository<PageView, String> {
    Optional<PageView> findByPage(String page);
}
