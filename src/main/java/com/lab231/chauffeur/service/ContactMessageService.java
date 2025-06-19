package com.lab231.chauffeur.service;

import com.lab231.chauffeur.model.ContactMessage;
import com.lab231.chauffeur.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {
    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public ContactMessage save(ContactMessage contactMessage) {
        if (contactMessage.getName() == null || contactMessage.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name field can not be blank or empty.");
        }
        if (contactMessage.getEmail() == null || contactMessage.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email field can not be blank or empty.");
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!contactMessage.getEmail().matches(emailRegex)) {
            throw new IllegalArgumentException("Email invalid.");
        }
        if (contactMessage.getMessage() == null || contactMessage.getMessage().trim().isEmpty()) {
            throw new IllegalArgumentException("Message field can not be blank or empty.");
        }
        return contactMessageRepository.save(contactMessage);
    }
} 