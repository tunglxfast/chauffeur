package com.lab231.chauffeur.controller;

import com.lab231.chauffeur.enums.PageName;
import com.lab231.chauffeur.repository.EntryRepository;
import com.lab231.chauffeur.repository.InfoRepository;
import com.lab231.chauffeur.service.PageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private EntryRepository entryRepo;

    @Autowired
    private InfoRepository infoRepo;

    @Autowired
    private PageViewService pageViewService;

    @GetMapping(value = {"/", "index", "/home"})
    public String home(Model model) {
        long viewCount = pageViewService.increaseView(PageName.ENTRY.name);
        List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
        model.addAttribute("intro", infoRepo.findByCode("intro"));
        model.addAttribute("about", infoRepo.findByCode("about"));
        model.addAttribute("promotions", entryRepo.findTop3ByOrderByPublishedDateDesc());
        model.addAttribute("viewCountDigits", viewCountDigits);
        return "home";
    }
}
