package com.tamaokishie.english_typing_master_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome to English Typing Master Server!";
    }
}
