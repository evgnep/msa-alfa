package ru.otus.authdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/public")
    public String publicUrl() {
        return "Public content: available to everyone";
    }

    @GetMapping("/profile")
    public String profileUrl() {
        return "Profile content: available to authenticated users";
    }

    @GetMapping("/admin")
    public String adminUrl() {
        return "Admin content: available to users with ADMIN role";
    }
}
