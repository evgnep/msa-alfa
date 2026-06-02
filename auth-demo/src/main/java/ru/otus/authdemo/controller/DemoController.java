package ru.otus.authdemo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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

    @GetMapping("/inner")
    public String innerUrl(@AuthenticationPrincipal Jwt jwt) {
        String clientIdFromToken = jwt.getClaimAsString("client_id");
        if (clientIdFromToken == null) {
            clientIdFromToken = jwt.getClaimAsString("azp");
        }
        return "/inner was called with valid token. client_id: " + clientIdFromToken;
    }
}
