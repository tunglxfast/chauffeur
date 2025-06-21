package com.lab231.chauffeur.controller;

import com.lab231.chauffeur.enums.PageName;
import com.lab231.chauffeur.model.ContactMessage;
import com.lab231.chauffeur.service.ContactMessageService;
import com.lab231.chauffeur.service.PageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactMessageService contactMessageService;
    @Autowired
    private PageViewService pageViewService;

    @GetMapping("/contact")
    public String showForm(Model model) {
        long viewCount = pageViewService.getViewCount(PageName.ENTRY.name);
        List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
        model.addAttribute("viewCountDigits", viewCountDigits);
        model.addAttribute("contact", new ContactMessage());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitForm(@Validated @ModelAttribute("contact") ContactMessage contact,
                             Model model) {
        try {
            contactMessageService.save(contact);
            model.addAttribute("successMessage", "Thank you for your message.");
            model.addAttribute("contact", new ContactMessage()); // reset form
        } catch (IllegalArgumentException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            model.addAttribute("contact", contact); // keep filled form
        }

        long viewCount = pageViewService.getViewCount(PageName.ENTRY.name);
        List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
        model.addAttribute("viewCountDigits", viewCountDigits);
        return "contact";
    }
}
