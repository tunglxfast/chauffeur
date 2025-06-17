package com.lab231.chauffeur.controller;

import com.lab231.chauffeur.model.ContactMessage;
import com.lab231.chauffeur.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    @Autowired
    private ContactMessageRepository repo;

    @GetMapping("/contact")
    public String showForm(Model model) {
        model.addAttribute("contact", new ContactMessage());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitForm(@Validated @ModelAttribute("contact") ContactMessage contact,
                             Model model) {
        repo.save(contact);
        model.addAttribute("successMessage", "Thank you for your message.");
        model.addAttribute("contact", new ContactMessage()); // reset form
        return "contact";
    }
}
