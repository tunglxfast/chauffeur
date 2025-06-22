package com.lab231.chauffeur.controller;

import com.lab231.chauffeur.enums.PageName;
import com.lab231.chauffeur.service.EntryService;
import com.lab231.chauffeur.service.GalleryVideoService;
import com.lab231.chauffeur.service.PageViewService;
import com.lab231.chauffeur.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GalleryController {
    @Autowired
    private EntryService entryService;
    @Autowired
    private GalleryVideoService galleryVideoService;
    @Autowired
    private PageViewService pageViewService;
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping("/gallery")
    public String gallery(Model model) {
        long viewCount = pageViewService.increaseView(PageName.ENTRY.name);
        List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
        model.addAttribute("galleryVideoUrl", galleryVideoService.getMainVideo());
        model.addAttribute("entries", entryService.findAll());
        model.addAttribute("viewCountDigits", viewCountDigits);
        model.addAttribute("advertisement", advertisementService.getFirstAdvertisement());
        return "gallery";
    }
}
