package com.lab231.chauffeur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab231.chauffeur.model.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findTop3ByOrderByPublishedDateDesc();
}
