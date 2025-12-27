package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ModuleController {
    
    @GetMapping("/modules/{id}")
    public String getModule(@PathVariable Long id) {
        return "Module";
    }
}
