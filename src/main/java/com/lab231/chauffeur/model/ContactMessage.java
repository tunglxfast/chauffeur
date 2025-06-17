package com.lab231.chauffeur.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class ContactMessage {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String message;

    private LocalDate sentAt = LocalDate.now();

    public ContactMessage() {
    }
    public ContactMessage(String name, String email, String message, LocalDate sentAt) {
        this(null, name, email, message, sentAt);
    }

    public ContactMessage(Long id, String name, String email, String message, LocalDate sentAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = message;
        this.sentAt = sentAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDate sentAt) {
        this.sentAt = sentAt;
    }
}
