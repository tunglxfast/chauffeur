package com.lab231.chauffeur.controller;

import com.lab231.chauffeur.enums.PageName;
import com.lab231.chauffeur.service.EntryService;
import com.lab231.chauffeur.service.InfoService;
import com.lab231.chauffeur.service.PageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.lab231.chauffeur.model.InfoEntry;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private EntryService entryService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private PageViewService pageViewService;

    @GetMapping(value = {"/", "index", "/home"})
    public String home(Model model) {
        long viewCount = pageViewService.increaseView(PageName.ENTRY.name);
        List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
        InfoEntry intro = infoService.findByCode("intro");
        InfoEntry about = infoService.findByCode("about");
        model.addAttribute("intro", intro);
        model.addAttribute("about", about);
        model.addAttribute("promotions", entryService.findTop3ByOrderByPublishedDateDesc());
        model.addAttribute("viewCountDigits", viewCountDigits);
        return "home";
    }
}
