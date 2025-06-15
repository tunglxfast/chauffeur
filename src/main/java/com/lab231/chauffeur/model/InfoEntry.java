package com.lab231.chauffeur.model;

import jakarta.persistence.*;

@Entity
public class InfoEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code; // 'intro', 'about'
    private String title;
    private String content;
    private String imageUrl;

    public InfoEntry() {
    }

    public InfoEntry(String code, String title, String content, String imageUrl) {
        this(null, code, title, content, imageUrl);
    }

    public InfoEntry(Long id, String code, String title, String content, String imageUrl) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
