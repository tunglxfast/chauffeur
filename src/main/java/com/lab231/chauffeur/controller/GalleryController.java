package com.lab231.chauffeur.controller;

import com.lab231.chauffeur.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
    @Autowired
    private EntryService entryService;

    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("galleryImages", entryService.getAllImageUrls());
        return "gallery";
    }
}
