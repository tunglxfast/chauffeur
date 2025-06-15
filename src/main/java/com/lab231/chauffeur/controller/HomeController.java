package com.lab231.chauffeur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lab231.chauffeur.repository.EntryRepository;
import com.lab231.chauffeur.repository.InfoRepository;

@Controller
public class HomeController {
    @Autowired
    private EntryRepository entryRepo;

    @Autowired
    private InfoRepository infoRepo;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("intro", infoRepo.findByCode("intro"));
        model.addAttribute("about", infoRepo.findByCode("about"));
        model.addAttribute("promotions", entryRepo.findTop3ByOrderByPublishedDateDesc());
        return "home";
    }
}
