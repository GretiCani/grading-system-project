package com.auth.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/auth")
    public String login() {
        return "login";
    }

    @PostMapping("/auth")
    public String loginFailed() {
        return "redirect:/authenticate?error=invalid username or password";
    }
}
