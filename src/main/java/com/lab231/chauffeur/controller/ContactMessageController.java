package com.lab231.chauffeur.controller;

import com.lab231.chauffeur.model.ContactMessage;
import com.lab231.chauffeur.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;

    @GetMapping("/admin/contact-messages")
    public String viewContactMessages(Model model) {
        List<ContactMessage> messages = contactMessageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "contact-messages";
    }
} 