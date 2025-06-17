package com.lab231.chauffeur.repository;

import com.lab231.chauffeur.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
