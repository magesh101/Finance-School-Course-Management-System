package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    @PostMapping("/enrollments")
    public String enroll() {
        return "Enrolled";
    }
}
