package com.examly.springapp.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping("/instructors")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor saved = instructorService.saveInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        if (instructors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        Instructor instructor = instructorService.getInstructorById(id);
        return ResponseEntity.ok(instructor);
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<Instructor> updateInstructor(
            @PathVariable Long id,
            @RequestBody Instructor instructor) {
        Instructor updated = instructorService.updateInstructor(id, instructor);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/instructors/page/{page}/{size}")
    public ResponseEntity<Page<Instructor>> getInstructorsPaginated(
            @PathVariable int page, @PathVariable int size) {
        Page<Instructor> instructors = instructorService.getInstructorsPaginated(page, size);
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/instructors/specialization/{specialization}")
    public ResponseEntity<?> getInstructorsBySpecialization(@PathVariable String specialization) {
        List<Instructor> instructors = instructorService.getInstructorsBySpecialization(specialization);
        if (instructors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No instructors found with specialization: " + specialization);
        }
        return ResponseEntity.ok(instructors);
    }
}
